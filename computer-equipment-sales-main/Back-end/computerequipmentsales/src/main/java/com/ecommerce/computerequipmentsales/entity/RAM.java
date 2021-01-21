package com.ecommerce.computerequipmentsales.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RAM extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "FREQUENCY_SPEED")
    private String frequencySpeed;

    @NotNull
    @Column(name = "CAS_LATENCY")
    private String casLatency;

    @NotNull
    @Column(name = "TIMING")
    private String timing;

    @NotNull
    @Column(name = "VOLTAGE")
    private String voltage;

    @NotNull
    @Column(name = "COLOR")
    private String color;

    @NotNull
    @Column(name = "CAPACITY")
    private String capacity;

    @NotNull
    @Column(name = "CHANNEL_TYPE")
    private String channelType;

    @NotNull
    @Column(name = "RAM_COMPATIBILITY")
    private String ramCompatibility;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
