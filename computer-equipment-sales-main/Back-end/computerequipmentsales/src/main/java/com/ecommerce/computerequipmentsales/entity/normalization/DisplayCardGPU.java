package com.ecommerce.computerequipmentsales.entity.normalization;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DISPLAY_CARD_GPU")
public class DisplayCardGPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "GPU_SERIAL")
    private String gpuSerial;

    @NotNull
    @Column(name = "GPU_MODEL")
    private String gpuModel;
}
