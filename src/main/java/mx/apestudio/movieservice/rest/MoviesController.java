package mx.apestudio.movieservice.rest;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import mx.apestudio.movieservice.dto.OmdbResponse;
import mx.apestudio.movieservice.dto.TasteDiveResponse;
import mx.apestudio.movieservice.model.MovieResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class MoviesController {

    private final Logger log = LoggerFactory.getLogger(MoviesController.class);

    private final RestTemplate omdbRestTemplate;

    private final RestTemplate tasteDiveRestTemplate;

    private final RestTemplate tmdbRestTemplate;

    public MoviesController(RestTemplate omdbRestTemplate, RestTemplate tasteDiveRestTemplate,
                            RestTemplate tmdbRestTemplate) {
        this.omdbRestTemplate = omdbRestTemplate;
        this.tasteDiveRestTemplate = tasteDiveRestTemplate;
        this.tmdbRestTemplate = tmdbRestTemplate;
    }

    @GetMapping("/movies/findByTitle")
    public MovieResponse findByTitle(@RequestParam String title){
        log.debug("omdb url: {}", omdbRestTemplate.getUriTemplateHandler().expand("/?t={title}", title));
        OmdbResponse omdbResponse = omdbRestTemplate.getForObject("/?t={title}", OmdbResponse.class, title);
        log.debug("tasteDive url: {}", tasteDiveRestTemplate.getUriTemplateHandler().expand("/similar?q={title}", title));
        TasteDiveResponse tasteDiveResponse = tasteDiveRestTemplate.getForObject("/similar?q={title}",
                TasteDiveResponse.class, title);
        log.debug("tasteDive response: {}", tasteDiveResponse);
        log.debug("tmdb url: {}", tmdbRestTemplate.getUriTemplateHandler().expand("/search/movie?query={title}", title));
        String tmdbResponse = tmdbRestTemplate.getForObject("/search/movie?query={title}", String.class, title);
        log.debug("tmdbResponse: {}", tmdbResponse);
        List<Double> vote_average = JsonPath.read(tmdbResponse,"$.results[?].vote_average", Filter.filter(Criteria.where("title").regex(Pattern.compile(title, Pattern.CASE_INSENSITIVE))));
        log.debug("vote_average: {}", vote_average);
        String yurl = Optional.ofNullable(tasteDiveResponse.getSimilar())
                .map(similar -> similar.getInfo())
                .map(info -> info.get(0))
                .map(info -> info.getYoutubeUrl())
                .orElse("default youtube url");
        return new MovieResponse()
                .title(omdbResponse.getTitle())
                .year(omdbResponse.getYear())
                .plot(omdbResponse.getPlot())
                .youtubeUrl(yurl)
                .voteAverage(vote_average.size()>0? vote_average.get(0).floatValue() : null);
    }
}
