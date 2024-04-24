package com.vendorservice.packman.repository;

import com.vendorservice.packman.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor,Long> {

    @Procedure(name = "sp_create_vendor")
    public void spCreateVendor(@Param("p_VEN_NAME") String name, @Param("p_VEN_LNAME") String lastname, @Param("p_VEN_EMAIL") String email);

    @Procedure(name = "sp_findVendor")
    public List<Vendor> findVendor();

}
