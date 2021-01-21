package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LaptopProcessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PROCESSOR_SERIAL")
    private String processorSerial;

    @NotNull
    @Column(name = "PROCESSOR_MODEL")
    private String processorModel;
}
