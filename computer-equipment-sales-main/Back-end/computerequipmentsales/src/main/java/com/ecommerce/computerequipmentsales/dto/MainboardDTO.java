package com.ecommerce.computerequipmentsales.dto;

import lombok.Data;

@Data
public class MainboardDTO extends BaseEntityDTO{

    private Long id;

    private String socket;

    private String chipset;

    private int ramSlotAmount;

    private String maxRamSupport;

    private String ramType;

    private String ramFrequencySpeed;

    private String compatibleProcessors;

    private String soundChip;

    private String soundChannelAmount;

    private boolean hdmi;

    private boolean displayPort;

    private Long mainboardRAMId;

    private Long stockId;
}
