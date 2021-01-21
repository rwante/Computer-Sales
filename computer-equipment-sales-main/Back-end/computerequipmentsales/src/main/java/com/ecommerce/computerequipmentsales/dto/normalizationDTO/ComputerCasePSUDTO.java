package com.ecommerce.computerequipmentsales.dto.normalizationDTO;

import lombok.Data;

@Data
public class ComputerCasePSUDTO {

    private Long id;

    private boolean psu;

    private String psuLocation;

    private String psuPowerRating;
}
