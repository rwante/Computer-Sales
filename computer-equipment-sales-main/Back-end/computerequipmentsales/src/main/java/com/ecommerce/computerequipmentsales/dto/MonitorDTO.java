package com.ecommerce.computerequipmentsales.dto;

import lombok.Data;

@Data
public class MonitorDTO extends BaseEntityDTO{

    private Long id;

    private String screenSize;

    private String resolution;

    private String refreshSpeed;

    private boolean hdr;

    private String reactionTime;

    private String outputs;

    private Long monitorScreenId;

    private Long stockId;
}
