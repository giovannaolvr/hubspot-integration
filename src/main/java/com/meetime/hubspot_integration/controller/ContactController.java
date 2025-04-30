package com.meetime.hubspot_integration.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meetime.hubspot_integration.dto.ContactRequest;
import com.meetime.hubspot_integration.service.HubspotContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final HubspotContactService hubspotContactService;

    public ContactController(HubspotContactService hubspotContactService) {
        this.hubspotContactService = hubspotContactService;
    }

   @PostMapping
    public ResponseEntity<String> createContact(@RequestBody ContactRequest contactRequest, @RequestHeader("Authorization") String authorizationHeader) {
        String accessToken = authorizationHeader.replace("Bearer ", "");
        String response = hubspotContactService.createContact(contactRequest, accessToken);
        return ResponseEntity.status(201).body(response);
    }
}
