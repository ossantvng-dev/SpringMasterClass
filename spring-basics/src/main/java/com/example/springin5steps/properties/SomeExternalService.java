package com.example.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

    @Value("${external.service.url}")
    private String url;

    @Value("${external.test.service.url}")
    private String testUrl;

    public String returnServiceUrl() { return url; }

    public String returnTestServiceUrl() { return testUrl; }
}
