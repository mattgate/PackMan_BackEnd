package com.vendorservice.packman.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TVENDOR")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="VEN_ID")
    private int id;

    @Column(name ="VEN_NAME")
    private String name;

    @Column(name ="VEN_LASTNAME")
    private String lastName;

    @Column(name ="VEN_EMAIL")
    private String email;

    @Column(name ="VEN_ADDRESS")
    private String address;

    @Column(name ="VEN_PHONE")
    private String phone;

    @Column(name ="VEN_PASSWORD")
    private String password;
}
