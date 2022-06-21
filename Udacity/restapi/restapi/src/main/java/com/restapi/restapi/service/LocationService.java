package com.restapi.restapi.service;

import com.restapi.restapi.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LocationService {
    List<Location> retrieveLocations();
}
