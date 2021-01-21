package com.ecommerce.computerequipmentsales.entity;

import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardGPU;
import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardMemory;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DisplayCard extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "PRODUCER")
    private String producer;

    @NotNull
    @Column(name = "MAX_CORE_SPEED")
    private String maxCoreSpeed;

    @NotNull
    @Column(name = "CUDA_AMOUNT")
    private int cudaAmount;

    @NotNull
    @Column(name = "OPENGL")
    private String openGL;

    @NotNull
    @Column(name = "DIRECTX")
    private String directX;

    @NotNull
    @Column(name = "HDMI")
    private String hdmi;

    @NotNull
    @Column(name = "DISPLAY_PORT")
    private String displayPort;

    @NotNull
    @Column(name = "MAX_RESOLUTION")
    private String maxResolution;

    @NotNull
    @Column(name = "SLI_SUPPORT")
    private boolean sliSupport;

    @NotNull
    @Column(name = "COOLING_FAN")
    private String coolingFan;

    @NotNull
    @Column(name = "SLOT")
    private int slot;

    @NotNull
    @Column(name = "HDCP_READY")
    private boolean hdcpReady;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "DISPLAY_CARD_GPU_ID")
    private DisplayCardGPU displayCardGPU;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "DISPLAY_CARD_MEMORY_ID")
    private DisplayCardMemory displayCardMemory;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
