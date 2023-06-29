package com.david.place.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.david.place.domain.PlaceRepository;
import com.david.place.domain.PlaceService;

@Configuration
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
