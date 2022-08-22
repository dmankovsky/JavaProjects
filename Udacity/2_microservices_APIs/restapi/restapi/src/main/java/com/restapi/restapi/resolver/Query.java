package com.restapi.restapi.resolver;

import com.restapi.restapi.entity.Dog;
import com.restapi.restapi.entity.Location;
import com.restapi.restapi.repository.DogRepository;
import com.restapi.restapi.repository.LocationRepository;
import com.restapi.restapi.service.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver{
    private LocationRepository locationRepository;
    private DogRepository dogRepository;

    public Query(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    @Autowired
    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
        // calls the findAllLocations from location.graphqls; will be mapped to it
    }

    public Iterable<Dog> findAllDogs (){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
