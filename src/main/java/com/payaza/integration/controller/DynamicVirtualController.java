package com.payaza.integration.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payaza.integration.model.DynamicVirtualPayload;
import com.payaza.integration.service.VirtualAccountService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/virtual")
public class DynamicVirtualController {

    @Autowired
    VirtualAccountService vService;

    @PostMapping("/create")
    public ResponseEntity<String> createVirtual(@RequestBody DynamicVirtualPayload payload) {
        // return null;
    return vService.createDynamicVirtual(payload);
    }

}