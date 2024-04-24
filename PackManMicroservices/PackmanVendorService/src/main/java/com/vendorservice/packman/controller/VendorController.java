package com.vendorservice.packman.controller;

import com.vendorservice.packman.dto.request.VendorDto;
import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendorservice")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createvendor")
    public void createVendor(@RequestBody VendorDto vendorDto){
        vendorService.createVendor(
                Vendor.builder()
                        .name(vendorDto.getName())
                        .lastName(vendorDto.getLastName())
                        .email(vendorDto.getEmail())
                        .build()
        );
    }

    @GetMapping("/findVendor")
    public ResponseEntity<?> findVendor(){
        List<VendorDto> vendorDtoList = vendorService.findVendor()
                .stream()
                .map(vendor -> VendorDto.builder()
                        .name(vendor.getName())
                        .lastName(vendor.getLastName())
                        .email(vendor.getEmail()).build()
                ).toList();

        return ResponseEntity.ok(vendorDtoList);
    }

}
