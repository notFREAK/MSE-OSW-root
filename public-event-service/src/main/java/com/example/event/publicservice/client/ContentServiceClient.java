package com.example.event.publicservice.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Component
public class ContentServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ContentServiceClient(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getSeatingPlanAndMultimedia(String eventId) {
        String url = "http://content-service/api/v1/contents/event/" + eventId;
        return restTemplate.getForObject(url, Map.class);
    }
}
