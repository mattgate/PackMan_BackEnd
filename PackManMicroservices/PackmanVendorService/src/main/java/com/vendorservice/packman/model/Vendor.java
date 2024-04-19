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
@Table(name = "TVENTOR")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="VEN_ID")
    private Long id;

    @Column(name ="VEN_NAME")
    private String name;

    @Column(name ="VEN_LNAME")
    private String lastName;

    @Column(name ="VEN_EMAIL")
    private String email;
}
