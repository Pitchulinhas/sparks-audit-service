package com.sparks.service.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class Request {

    @Id
    private String id;

    private String url;

    private String method;

    private String body;

    private String headers;

    private String cookies;

}
