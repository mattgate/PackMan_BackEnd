package com.vendorservice.packman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class createVendorRqDto {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String password;
}

