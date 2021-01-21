package com.ecommerce.computerequipmentsales.dto;

import lombok.Data;

@Data
public class DisplayCardDTO extends BaseEntityDTO{

    private Long id;

    private String producer;

    private String gpuSerial;

    private String gpuModel;

    private String maxCoreSpeed;

    private int cudaAmount;

    private String openGL;

    private String directX;

    private String memoryType;

    private String memorySpeed;

    private String memoryCapacity;

    private String memoryInterface;

    private String hdmi;

    private String displayPort;

    private String maxResolution;

    private boolean sliSupport;

    private String coolingFan;

    private int slot;

    private boolean hdcpReady;

    private Long displayCardGPUId;

    private Long displayCardMemoryId;

    private Long stockId;
}
