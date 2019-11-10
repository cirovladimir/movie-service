package mx.apestudio.movieservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestConfig {

    @Value("${omdb.api.url:http://www.omdbapi.com/?apikey=8ab01b20&}")
    String omdbApiUrl;

    @Value("${tastedive.api.url:https://tastedive.com/api?type=movie&info=1}")
    String tasteDiveUrl;

    @Value("${tmdb.api.url:https://api.themoviedb.org/3?api_key=617850a2cf7ef6cccbecc02ff6df21ba}")
    String tmdbUrl;

    @Bean
    public RestTemplate omdbRestTemplate(RestTemplateBuilder builder){
        return builder.uriTemplateHandler(new DefaultUriBuilderFactory(omdbApiUrl)).build();
    }

    @Bean
    public RestTemplate tmdbRestTemplate(RestTemplateBuilder builder){
        return builder.uriTemplateHandler(new DefaultUriBuilderFactory(tmdbUrl)).build();
    }

    @Bean
    public RestTemplate tasteDiveRestTemplate(RestTemplateBuilder builder){
        return builder.defaultHeader("User-Agent", "curl/7.64.1")
                .uriTemplateHandler(new DefaultUriBuilderFactory(tasteDiveUrl)).build();
    }
}
