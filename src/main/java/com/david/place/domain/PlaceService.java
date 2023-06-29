package com.david.place.domain;

import com.david.place.api.PlaceRequest;
import com.github.slugify.Slugify;

import reactor.core.publisher.Mono;

public class PlaceService {

    private PlaceRepository placeRepository;

    private Slugify slug;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slug = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), slug.slugify(placeRequest.name()), placeRequest.city(),
                placeRequest.state(),
                null, null);
        return placeRepository.save(place);
    }
}
