package com.vendorservice.packman.service;

import com.vendorservice.packman.model.Vendor;
import com.vendorservice.packman.repository.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<Vendor> findVendorById(Long id){
        return vendorRepository.findById(id);
    }

    public void save(Vendor vendor){
        vendorRepository.save(vendor);
    }

}
