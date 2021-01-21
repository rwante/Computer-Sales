package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LAPTOP_RAM")
public class LaptopRAM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "RAM")
    private String ram;

    @NotNull
    @Column(name = "RAM_TYPE")
    private String ramType;

    @NotNull
    @Column(name = "RAM_SPEED")
    private String ramSpeed;
}
