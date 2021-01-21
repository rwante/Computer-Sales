package com.ecommerce.computerequipmentsales.entity;

import com.ecommerce.computerequipmentsales.entity.normalization.*;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Laptop extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "DISK_ROTATION_SPEED")
    private String diskRotationSpeed;

    @NotNull
    @Column(name = "HDMI")
    private boolean hdmi;

    @NotNull
    @Column(name = "CAMERA")
    private boolean camera;

    @NotNull
    @Column(name = "BLUETOOTH")
    private String bluetooth;

    @NotNull
    @Column(name = "WIRELESS")
    private String wireless;

    @NotNull
    @Column(name = "ETHERNET")
    private boolean ethernet;

    @NotNull
    @Column(name = "TOUCHPAD")
    private boolean touchpad;

    @NotNull
    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_SCREEN_ID")
    private LaptopScreen laptopScreen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_SSD_ID")
    private LaptopSSD laptopSSD;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_HDD_ID")
    private LaptopHDD laptopHDD;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_GPU_ID")
    private LaptopGPU laptopGPU;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_PROCESSOR_ID")
    private LaptopProcessor laptopProcessor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LAPTOP_RAM_ID")
    private LaptopRAM laptopRAM;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
