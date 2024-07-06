package com.payaza.integration.model;

import lombok.Data;

@Data
public class DynamicVirtualPayload {

        private String requestApplication;
        private String applicationModule;
        private String applicationVersion;
        private String requestClass;
        private String customerFirstName;
        private String customerLastName;
        private String customerEmail;
        private String customerPhone;
        private String virtualAccountProvider;
        private Long paymentAmount;
        private String paymentReference;
}
