package com.meetime.hubspot_integration.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String email;
    private String firstName;
    private String lastName;
}