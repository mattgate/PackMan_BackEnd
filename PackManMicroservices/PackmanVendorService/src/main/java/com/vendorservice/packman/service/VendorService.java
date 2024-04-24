package com.vendorservice.packman.service;

import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.repository.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VendorService {

    @Autowired
    private IVendorRepository vendorRepository;

    public void createVendor(Vendor vendor){
        vendorRepository.spCreateVendor(vendor.getName(),vendor.getLastName(),vendor.getEmail());
    }

    public List<Vendor> findVendor(){
        return vendorRepository.findVendor();
    }

}
