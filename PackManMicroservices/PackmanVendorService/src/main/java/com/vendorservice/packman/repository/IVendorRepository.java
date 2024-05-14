package com.vendorservice.packman.repository;

import com.vendorservice.packman.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Integer> {

    @Transactional
    @Procedure(procedureName = "sp_create_vendor")
    public void createVendor
            (
                    @Param("p_VEN_NAME") String name,
                    @Param("p_VEN_LASTNAME") String lastname,
                    @Param("p_VEN_EMAIL") String email,
                    @Param("p_VEN_ADDRESS") String address,
                    @Param("p_VEN_PHONE") String phone,
                    @Param("p_VEN_PASSWORD") String password

            );

    @Procedure(procedureName = "sp_find_all_vendor")
    public List<Vendor> findAllVendor();

}
