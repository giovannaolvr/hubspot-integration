package com.meetime.hubspot_integration.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.meetime.hubspot_integration.dto.ContactRequest;

@Service
public class HubspotContactService {

    @Value("${hubspot.api-url}")
    private String apiUrl;

    private final HubspotOAuthService hubspotOAuthService;

    public HubspotContactService(HubspotOAuthService hubspotOAuthService) {
        this.hubspotOAuthService = hubspotOAuthService;
    }

    public String createContact(ContactRequest contactRequest, String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "/crm/v3/objects/contacts";

        Map<String, Object> properties = new HashMap<>();
        properties.put("email", contactRequest.getEmail());
        properties.put("firstname", contactRequest.getFirstName());
        properties.put("lastname", contactRequest.getLastName());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("properties", properties);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao criar contato no HubSpot: " + response.getBody());
        }
    }
}