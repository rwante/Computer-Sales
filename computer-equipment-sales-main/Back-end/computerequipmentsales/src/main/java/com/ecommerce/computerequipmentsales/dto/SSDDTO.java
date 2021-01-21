package com.ecommerce.computerequipmentsales.dto;

import lombok.Data;

@Data
public class SSDDTO extends BaseEntityDTO{

    private Long id;

    private String capacity;

    private String type;

    private String accessInterface;

    private String chip;

    private String maxReadingSpeed;

    private String maxWritingSpeed;

    private Long stockId;
}
