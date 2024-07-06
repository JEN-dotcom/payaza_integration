package com.payaza.integration.service;

import org.springframework.http.ResponseEntity;

import com.payaza.integration.controller.DynamicVirtualController;
import com.payaza.integration.model.DynamicVirtualPayload;

public interface VirtualAccountService {

    ResponseEntity<String> createDynamicVirtual(DynamicVirtualPayload payload);
    
} 