package com.vendorservice.packman.controller;

import com.vendorservice.packman.dto.createVendorRqDto;
import com.vendorservice.packman.dto.findAllVendorRsDto;
import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void createVendor(@RequestBody createVendorRqDto createVendorRqDto){
        vendorService.createVendor(
                Vendor.builder()
                        .name(createVendorRqDto.getName())
                        .lastName(createVendorRqDto.getLastName())
                        .email(createVendorRqDto.getEmail())
                        .address(createVendorRqDto.getAddress())
                        .phone(createVendorRqDto.getPhone())
                        .password(createVendorRqDto.getPassword())
                        .build()
        );
    }

    @GetMapping("/findallvendor")
    public ResponseEntity<?> findAllVendor(){
        List<findAllVendorRsDto> findAllVendorRsList = vendorService.findAllVendor()
                .stream()
                .map(vendor -> findAllVendorRsDto.builder()
                        .name(vendor.getName())
                        .lastName(vendor.getLastName())
                        .email(vendor.getEmail())
                        .address(vendor.getAddress())
                        .phone(vendor.getAddress())
                        .build()
                ).toList();

        return ResponseEntity.ok(findAllVendorRsList);
    }

//    @PutMapping("/updateventor")
//    public ResponseEntity<?> updateVendor(@RequestBody VendorDto vendorDto){
//
//        Optional<Vendor> optionalVendor = vendorService.findVendorById(vendorDto.getId());
//
//        if (optionalVendor.isPresent()){
//            Vendor vendor = optionalVendor.get();
//            vendor.setName(vendorDto.getName());
//            vendor.setLastName(vendorDto.getLastName());
//            vendor.setEmail(vendorDto.getEmail());
//
//            vendorService.saveVendor(vendor);
//
//            return ResponseEntity.ok("Se actualizo el dato correctamente.");
//        }
//
//        return ResponseEntity.notFound().build();
//
//    }
//
//    @DeleteMapping("/deletevendorbyid/{id}")
//    public ResponseEntity<?> deleteVendorById(@PathVariable("id") Long id){
//
//        Optional<Vendor> optionalVendor = vendorService.findVendorById(id);
//
//        if(optionalVendor.isPresent()){
//            vendorService.deleteVendorById(id);
//            return ResponseEntity.ok("Se eliminó el dato correctamente.");
//        }
//
//        return ResponseEntity.badRequest().build();
//    }

}
