package com.restapi.restapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.restapi.restapi.entity.Dog;
import com.restapi.restapi.entity.Location;
import com.restapi.restapi.exception.BreedNotFoundException;
import com.restapi.restapi.exception.LocationNotFoundException;
import com.restapi.restapi.repository.DogRepository;
import com.restapi.restapi.repository.LocationRepository;
import com.restapi.restapi.service.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    // mutator allows to update data in the DB
    // GraphQLMutationResolver automatically recognized which mutation to call from those defined in the Mutation section from schema. Each method in schema is mapped to one here

    private LocationRepository locationRepository;
    private DogRepository dogRepository;

    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Autowired
    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
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
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent()){
            Location location = optionalLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }

    // adding the same for dogs
    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // loop through all dogs to check their breed
        for (Dog d:allDogs){
            if(d.getBreed().equals(breed)){
                // delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // if breed does not exist - exception
        if (!deleted){
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName (String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            // set new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
