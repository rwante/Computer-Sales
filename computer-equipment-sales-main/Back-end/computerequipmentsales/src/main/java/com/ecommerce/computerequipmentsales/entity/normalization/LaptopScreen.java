package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LaptopScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "SCREEN_SIZE")
    private String screenSize;

    @NotNull
    @Column(name = "SCREEN_RESOLUTION")
    private String screenResolution;
}
