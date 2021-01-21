package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "COMPUTER_CASE_PSU")
public class ComputerCasePSU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PSU")
    private boolean psu;

    @NotNull
    @Column(name = "PSU_LOCATION")
    private String psuLocation;

    @NotNull
    @Column(name = "PSU_POWER_RATING")
    private String psuPowerRating;
}
