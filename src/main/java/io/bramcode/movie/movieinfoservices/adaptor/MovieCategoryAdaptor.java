package io.bramcode.movie.movieinfoservices.adaptor;

import io.bramcode.movie.movieinfoservices.model.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class MovieCategoryAdaptor {
    @Value("${integration.movie.get-category-url}")
    private String movieCategoryUrl;

    @Autowired
    private RestTemplate restTemplate;

    public CategoryResponse getCategoryById(String categoryId){

        Map<String, String> params = new HashMap<>();
        params.put("id", categoryId);
        URI uriComponents = UriComponentsBuilder
                .fromHttpUrl(movieCategoryUrl)
                .buildAndExpand(params)
                .toUri();
        return restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET, null, CategoryResponse.class).getBody();
    }
}
