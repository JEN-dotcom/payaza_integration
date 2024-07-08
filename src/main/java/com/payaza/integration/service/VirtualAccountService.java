package com.payaza.integration.service;

import org.springframework.http.ResponseEntity;

import com.payaza.integration.model.ServicePayloadWrapper;

public interface VirtualAccountService {

    ResponseEntity<String> createDynamicVirtual(ServicePayloadWrapper payload);
    
} 