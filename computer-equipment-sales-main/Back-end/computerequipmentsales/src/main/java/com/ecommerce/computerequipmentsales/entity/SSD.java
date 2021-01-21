package com.ecommerce.computerequipmentsales.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SSD extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "CAPACITY")
    private String capacity;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "ACCESS_INTERFACE")
    private String accessInterface;

    @NotNull
    @Column(name = "CHIP")
    private String chip;

    @NotNull
    @Column(name = "MAX_READING_SPEED")
    private String maxReadingSpeed;

    @NotNull
    @Column(name = "MAX_WRITING_SPEED")
    private String maxWritingSpeed;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
