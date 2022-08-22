package com.graphqlapi.graphql.service;

import com.graphqlapi.graphql.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
}
