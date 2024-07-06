package com.payaza.integration.service.serviceImpl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payaza.integration.model.DynamicVirtualPayload;
import com.payaza.integration.service.VirtualAccountService;

public class VirtualAccountServiceImpl implements VirtualAccountService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public VirtualAccountServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;

    }

    @Value("${payaza.url.createDynamicVirtual}")
    private String url;

    @Value("${payaza.secret.key}")
    private String key;

    @Override
    public ResponseEntity<String> createDynamicVirtual(DynamicVirtualPayload payload) {

        return new ResponseEntity<>(createVirtual(payload), HttpStatusCode.valueOf(200));

    }

    private String createVirtual(DynamicVirtualPayload payload) {

        String requestBodyJson = "";
        try {
            requestBodyJson = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Payaza " + encodeToBase64(key));
        headers.set("X-TenantID", "live");

        HttpEntity<String> entity = new HttpEntity<>(requestBodyJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    private String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

}
