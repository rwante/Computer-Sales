package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProcessorCore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "CORE_AMOUNT")
    private int coreAmount;

    @NotNull
    @Column(name = "CORE_NAME")
    private String coreName;
}
