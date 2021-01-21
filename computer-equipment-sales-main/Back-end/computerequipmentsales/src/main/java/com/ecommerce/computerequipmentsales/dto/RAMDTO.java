package com.ecommerce.computerequipmentsales.dto;

import lombok.Data;

@Data
public class RAMDTO extends BaseEntityDTO{

    private Long id;

    private String type;

    private String frequencySpeed;

    private String casLatency;

    private String timing;

    private String voltage;

    private String color;

    private String capacity;

    private String channelType;

    private String ramCompatibility;

    private Long stockId;
}
