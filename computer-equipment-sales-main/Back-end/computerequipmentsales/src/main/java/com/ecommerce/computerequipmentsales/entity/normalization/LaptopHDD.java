package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LAPTOP_HDD")
public class LaptopHDD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "HDD")
    private boolean hdd;

    @NotNull
    @Column(name = "HDD_CAPACITY")
    private String hddCapacity;
}
