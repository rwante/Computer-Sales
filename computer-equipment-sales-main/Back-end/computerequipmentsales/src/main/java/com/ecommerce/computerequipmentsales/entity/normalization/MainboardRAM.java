package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MAINBOARD_RAM")
public class MainboardRAM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "RAM_SLOT_AMOUNT")
    private int ramSlotAmount;

    @NotNull
    @Column(name = "MAX_RAM_SUPPORT")
    private String maxRamSupport;

    @NotNull
    @Column(name = "RAM_TYPE")
    private String ramType;

    @NotNull
    @Column(name = "RAM_FREQUENCY_SPEED")
    private String ramFrequencySpeed;
}
