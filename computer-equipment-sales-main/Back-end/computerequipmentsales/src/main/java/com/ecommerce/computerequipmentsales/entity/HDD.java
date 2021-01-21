package com.ecommerce.computerequipmentsales.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HDD extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ACCESS_TYPE")
    private String accessType;

    @NotNull
    @Column(name = "CACHE_MEMORY")
    private String cacheMemory;

    @NotNull
    @Column(name = "DISK_SIZE")
    private String diskSize;

    @NotNull
    @Column(name = "DISK_TYPE")
    private String diskType;

    @NotNull
    @Column(name = "ROTATION_SPEED")
    private String rotationSpeed;

    @NotNull
    @Column(name = "THICKNESS")
    private String thickness;

    @NotNull
    @Column(name = "CAPACITY")
    private String capacity;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
