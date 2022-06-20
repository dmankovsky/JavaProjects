package com.graphqlapi.graphql.repository;

import com.graphqlapi.graphql.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
