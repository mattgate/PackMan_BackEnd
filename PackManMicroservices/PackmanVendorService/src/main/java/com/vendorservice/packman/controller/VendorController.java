package com.vendorservice.packman.controller;

import com.vendorservice.packman.dto.request.SetVendorRQ;
import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendorservice")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/setvendor")
    public void setVendor(@RequestBody SetVendorRQ setVendorRQ){
        vendorService.setVendor(
                Vendor.builder()
                        .name(setVendorRQ.getName())
                        .lastName(setVendorRQ.getLastName())
                        .email(setVendorRQ.getEmail())
                        .build()
        );
    }

}
