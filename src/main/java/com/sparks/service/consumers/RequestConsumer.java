package com.sparks.service.consumers;

import com.google.gson.Gson;
import com.sparks.service.entities.Request;
import com.sparks.service.responses.ServiceResponse;
import com.sparks.service.services.RequestService;
import com.sparks.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestConsumer {

    @Autowired
    private RequestService requestService;

    private Gson gson;

    public RequestConsumer() {
        this.gson = new Gson();
    }

    @KafkaListener(id = "${spring.kafka.topics.request.create}", topics = "${spring.kafka.topics.request.create}")
    @SendTo
    public String createRequest(String createRequestInputAsJson) {
        ServiceResponse<Request> response = new ServiceResponse<>();

        try {
            createRequestInputAsJson = StringUtils.trimText(createRequestInputAsJson, "\"");

            createRequestInputAsJson = StringUtils.removeBackSlash(createRequestInputAsJson);

            Request createRequestInput = new Gson().fromJson(createRequestInputAsJson, Request.class);

            Request requestCreated = this.requestService.createRequest(createRequestInput);

            response.setData(requestCreated);
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }

        return gson.toJson(response);
    }

    @KafkaListener(id = "${spring.kafka.topics.request.find-all}", topics = "${spring.kafka.topics.request.find-all}")
    @SendTo
    public String findAllRequests() {
        ServiceResponse<List<Request>> response = new ServiceResponse<>();

        try {
            List<Request> requestsFound = this.requestService.findAllRequests();

            response.setData(requestsFound);
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }

        return gson.toJson(response);
    }

    @KafkaListener(id = "${spring.kafka.topics.request.find-by-id}", topics = "${spring.kafka.topics.request.find-by-id}")
    @SendTo
    public String findRequestById(String id) {
        ServiceResponse<Request> response = new ServiceResponse<>();

        try {
            id = StringUtils.trimText(id, "\"");

            Request requestFound = this.requestService.findRequestById(id);

            response.setData(requestFound);
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }

        return gson.toJson(response);
    }

}
