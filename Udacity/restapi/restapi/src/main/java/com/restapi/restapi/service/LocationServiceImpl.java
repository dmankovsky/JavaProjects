package com.restapi.restapi.service;

import com.restapi.restapi.entity.Location;
import com.restapi.restapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> retrieveLocations(){
        return(List<Location>) locationRepository.findAll();
    }
}
