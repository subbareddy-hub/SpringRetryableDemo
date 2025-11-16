package com.codesnippet.SpringRetryableDemo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

    @Retryable(
            retryFor = RuntimeException.class,
            maxAttempts = 4,
            backoff = @Backoff(delay = 2000, multiplier = 2.0)
    )
    public String callExternalApi() {
        // Simulate failure
        System.out.println("Retrying");
        throw new RuntimeException("API is down");
    }

    @Recover
    public String recover(RuntimeException e) {
        System.out.println("Called @Recover because all retries failed");
        return "Fallback response from @Recover";
    }
}
