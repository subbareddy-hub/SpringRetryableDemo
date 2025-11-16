package com.codesnippet.SpringRetryableDemo.controller;

import com.codesnippet.SpringRetryableDemo.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    private final ExternalApiService externalApiService;

    public RetryController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/retry-test")
    public String retryTest() {
        return externalApiService.callExternalApi();
    }
}
