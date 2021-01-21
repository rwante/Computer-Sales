package com.ecommerce.computerequipmentsales.dto.normalizationDTO;

import lombok.Data;

@Data
public class DisplayCardMemoryDTO {

    private Long id;

    private String memoryType;

    private String memorySpeed;

    private String memoryCapacity;

    private String memoryInterface;
}
