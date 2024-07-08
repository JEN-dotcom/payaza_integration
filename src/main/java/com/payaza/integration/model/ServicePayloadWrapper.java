package com.payaza.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data 
class DynamicVirtualPayload {

    @JsonProperty("request_application")
    private String requestApplication;

    @JsonProperty("application_module")
    private String applicationModule;

    @JsonProperty("application_version")
    private String applicationVersion;

    @JsonProperty("request_class")
    private String requestClass;

    @JsonProperty("customer_first_name")
    private String customerFirstName;

    @JsonProperty("customer_last_name")
    private String customerLastName;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_phone")
    private String customerPhone;

    @JsonProperty("virtual_account_provider")
    private String virtualAccountProvider;

    @JsonProperty("payment_amount")
    private Long paymentAmount;

    @JsonProperty("payment_reference")
    private String paymentReference;
}

@Data
@ToString
public class ServicePayloadWrapper {

    @JsonProperty("service_type")
    private String serviceType;

    @JsonProperty("service_payload")
    private DynamicVirtualPayload servicePayload;
}