package com.sparks.service.services;

import com.sparks.service.entities.Request;
import com.sparks.service.mappers.RequestMapper;
import com.sparks.service.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestMapper mapper;

    @Autowired
    private RequestRepository requestRepository;

    public Request createRequest(Request createRequestInput) {
        return this.requestRepository.insert(createRequestInput);
    }

    public List<Request> findAllRequests() {
        return this.requestRepository.findAll();
    }

    public Request findRequestById(String id) {
        return this.requestRepository.findById(id).orElse(null);
    }

}
