package com.vendorservice.packman.controller;

import com.vendorservice.packman.dto.VendorDto;
import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
                        .id(vendorDto.getId())
                        .name(vendorDto.getName())
                        .lastName(vendorDto.getLastName())
                        .email(vendorDto.getEmail())
                        .build()
        );
    }

    @GetMapping("/findvendor")
    public ResponseEntity<?> findVendor(){
        List<VendorDto> vendorDtoList = vendorService.findVendor()
                .stream()
                .map(vendor -> VendorDto.builder()
                        .id(vendor.getId())
                        .name(vendor.getName())
                        .lastName(vendor.getLastName())
                        .email(vendor.getEmail()).build()
                ).toList();

        return ResponseEntity.ok(vendorDtoList);
    }

    @PutMapping("/updateventor")
    public ResponseEntity<?> updateVendor(@RequestBody VendorDto vendorDto){

        Optional<Vendor> optionalVendor = vendorService.findVendorById(vendorDto.getId());

        if (optionalVendor.isPresent()){
            Vendor vendor = optionalVendor.get();
            vendor.setName(vendorDto.getName());
            vendor.setLastName(vendorDto.getLastName());
            vendor.setEmail(vendorDto.getEmail());

            vendorService.saveVendor(vendor);

            return ResponseEntity.ok("Se actualizo el dato correctamente.");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/deletevendorbyid/{id}")
    public ResponseEntity<?> deleteVendorById(@PathVariable("id") Long id){

        Optional<Vendor> optionalVendor = vendorService.findVendorById(id);

        if(optionalVendor.isPresent()){
            vendorService.deleteVendorById(id);
            return ResponseEntity.ok("Se elimino el dato correctamente.");
        }

        return ResponseEntity.badRequest().build();
    }

}
