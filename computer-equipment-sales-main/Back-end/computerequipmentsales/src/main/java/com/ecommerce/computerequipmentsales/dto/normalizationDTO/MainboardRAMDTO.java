package com.ecommerce.computerequipmentsales.dto.normalizationDTO;

import lombok.Data;

@Data
public class MainboardRAMDTO {

    private Long id;

    private int ramSlotAmount;

    private String maxRamSupport;

    private String ramType;

    private String ramFrequencySpeed;
}
