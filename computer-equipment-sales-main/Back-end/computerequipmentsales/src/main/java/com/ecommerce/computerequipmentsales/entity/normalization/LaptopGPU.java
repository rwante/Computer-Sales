package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LAPTOP_GPU")
public class LaptopGPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "GPU_PRODUCER")
    private String gpuProducer;

    @NotNull
    @Column(name = "GPU_MODEL")
    private String gpuModel;

    @NotNull
    @Column(name = "GPU_SERIAL")
    private String gpuSerial;

    @NotNull
    @Column(name = "GPU_RAM_SHARING")
    private boolean gpuRamSharing;

    @NotNull
    @Column(name = "GPU_RAM")
    private String gpuRam;
}
