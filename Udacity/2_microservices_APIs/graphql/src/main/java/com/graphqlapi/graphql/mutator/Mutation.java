package com.graphqlapi.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlapi.graphql.entity.Location;
import com.graphqlapi.graphql.exception.LocationNotFoundException;
import com.graphqlapi.graphql.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address){
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id){
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String newName, Long id){
        Optional<Location> existingLocation = locationRepository.findById(id);

        if(existingLocation.isPresent()) {
            Location location = existingLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }
}
