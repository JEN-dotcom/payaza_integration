package com.payaza.integration.service.serviceImpl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.payaza.integration.model.ServicePayloadWrapper;
import com.payaza.integration.service.VirtualAccountService;

@Service
public class VirtualAccountServiceImpl implements VirtualAccountService {

    private final RestTemplate restTemplate;

    public VirtualAccountServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${payaza.url.createDynamicVirtual}")
    private String url;

    @Value("${payaza.secret.key}")
    private String key;

    @Override
    public ResponseEntity<String> createDynamicVirtual(ServicePayloadWrapper payload) {

        return new ResponseEntity<>(createVirtual(payload), HttpStatusCode.valueOf(200));

    }

    private String createVirtual(ServicePayloadWrapper payload) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Payaza " + encodeToBase64(key));
        headers.set("Content-Type", "application/json");
        headers.set("X-TenantID", "live");

        HttpEntity<ServicePayloadWrapper> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    private String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

}
