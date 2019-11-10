package mx.apestudio.movieservice.rest;

import mx.apestudio.movieservice.model.Movie;
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

    public MoviesController(RestTemplate omdbRestTemplate, RestTemplate tasteDiveRestTemplate) {
        this.omdbRestTemplate = omdbRestTemplate;
        this.tasteDiveRestTemplate = tasteDiveRestTemplate;
    }

    @GetMapping("/movies/findByTitle")
    public Movie findByTitle(@RequestParam String title){
        log.debug("omdb url: {}", omdbRestTemplate.getUriTemplateHandler().expand("/?t={title}", title));
        Movie movie = omdbRestTemplate.getForObject("/?t={title}", Movie.class, title);
        log.debug("tasteDive url: {}", tasteDiveRestTemplate.getUriTemplateHandler().expand("/similar?q={title}", title));
        String tasteDiveResponse = tasteDiveRestTemplate.getForObject("/similar?q={title}", String.class, title);
        log.debug("tasteDive response: {}", tasteDiveResponse);
        return movie;
    }
}
