package com.ecommerce.computerequipmentsales.entity;

import com.ecommerce.computerequipmentsales.entity.normalization.ProcessorCore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Processor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PROCESSOR_SOCKET_TYPE")
    private String processorSocketType;

    @NotNull
    @Column(name = "MODEL")
    private String model;

    @NotNull
    @Column(name = "FREQUENCY_SPEED")
    private String frequencySpeed;

    @NotNull
    @Column(name = "INTERNAL_GRAPHIC")
    private String internalGraphic;

    @NotNull
    @Column(name = "THREAD_AMOUNT")
    private int threadAmount;

    @NotNull
    @Column(name = "COOLER")
    private boolean cooler;

    @NotNull
    @Column(name = "PROCESSOR_TYPE")
    private String processorType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PROCESSOR_CORE_ID")
    private ProcessorCore processorCore;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
