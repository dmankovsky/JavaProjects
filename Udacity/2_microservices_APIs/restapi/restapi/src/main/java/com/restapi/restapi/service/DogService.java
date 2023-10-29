package com.restapi.restapi.service;

import com.restapi.restapi.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();


}
