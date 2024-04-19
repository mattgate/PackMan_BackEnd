package com.vendorservice.packman.repository;

import com.vendorservice.packman.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor,Long> {

    @Procedure(name = "vendorPKG.sp_set_vendor")
    public void spSetVendor(@Param("p_VEN_NAME") String name, @Param("p_VEN_LNAME") String lastname, @Param("p_VEN_EMAIL") String email);

}
