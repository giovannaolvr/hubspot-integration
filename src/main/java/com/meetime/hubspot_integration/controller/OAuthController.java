package com.meetime.hubspot_integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meetime.hubspot_integration.service.HubspotOAuthService;

@RestController
public class OAuthController {

    private final HubspotOAuthService hubspotOAuthService;

    public OAuthController(HubspotOAuthService hubspotOAuthService) {
        this.hubspotOAuthService = hubspotOAuthService;
    }

    @GetMapping("/oauth/authorize")
    public String authorize() {
        return hubspotOAuthService.generateAuthorizationUrl();
    }

    // Endpoint para processar o callback da OAuth
    @GetMapping("/oauth/callback")
    public String processCallback(@RequestParam("code") String code) {
        // Chama o serviço para trocar o código de autorização pelo token de acesso
        String accessToken = hubspotOAuthService.exchangeAuthorizationCodeForToken(code);
        
        // Retorna o token de acesso ou uma resposta indicando sucesso
        return "Access Token: " + accessToken;
    }
}
