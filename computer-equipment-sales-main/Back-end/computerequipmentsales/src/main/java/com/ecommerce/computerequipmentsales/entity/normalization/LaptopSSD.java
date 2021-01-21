package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LAPTOP_SSD")
public class LaptopSSD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "SSD")
    private boolean ssd;

    @NotNull
    @Column(name = "SSD_CAPACITY")
    private String ssdCapacity;
}
