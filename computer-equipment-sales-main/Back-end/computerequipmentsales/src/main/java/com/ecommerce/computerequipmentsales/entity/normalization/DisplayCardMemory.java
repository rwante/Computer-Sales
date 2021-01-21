package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DisplayCardMemory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "MEMORY_TYPE")
    private String memoryType;

    @NotNull
    @Column(name = "MEMORY_SPEED")
    private String memorySpeed;

    @NotNull
    @Column(name = "MEMORY_CAPACITY")
    private String memoryCapacity;

    @NotNull
    @Column(name = "MEMORY_INTERFACE")
    private String memoryInterface;
}
