package mx.apestudio.movieservice.rest;

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
        return new MovieResponse()
                .title(omdbResponse.getTitle())
                .year(omdbResponse.getYear())
                .plot(omdbResponse.getPlot())
                .youtubeUrl(tasteDiveResponse.getSimilar().getInfo().get(0).getYoutubeUrl());
    }
}
