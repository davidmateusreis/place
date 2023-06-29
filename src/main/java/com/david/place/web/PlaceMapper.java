package com.david.place.web;

import com.david.place.api.PlaceResponse;
import com.david.place.domain.Place;

public class PlaceMapper {

    public static PlaceResponse fromPlaceToResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(), place.city(), place.state(), place.createdAt(),
                place.updatedAt());
    }
}
