package com.sparks.service.repositories;

import com.sparks.service.entities.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request, String> {

}
