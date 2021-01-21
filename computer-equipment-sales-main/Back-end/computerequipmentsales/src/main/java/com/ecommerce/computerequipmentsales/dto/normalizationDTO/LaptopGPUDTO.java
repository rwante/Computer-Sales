package com.ecommerce.computerequipmentsales.dto.normalizationDTO;

import lombok.Data;

@Data
public class LaptopGPUDTO {

    private Long id;

    private String gpuProducer;

    private String gpuModel;

    private String gpuSerial;

    private boolean gpuRamSharing;

    private String gpuRam;
}
