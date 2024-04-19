package com.vendorservice.packman.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class SetVendorRQ {
    private String name;
    private String lastName;
    private String email;
}

