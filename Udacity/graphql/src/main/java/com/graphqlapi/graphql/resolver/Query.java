package com.graphqlapi.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlapi.graphql.entity.Location;
import com.graphqlapi.graphql.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private LocationRepository locationRepository;

    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }
}
