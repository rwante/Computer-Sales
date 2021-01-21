package com.ecommerce.computerequipmentsales.entity;

import com.ecommerce.computerequipmentsales.entity.normalization.MainboardRAM;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Mainboard extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "SOCKET")
    private String socket;

    @NotNull
    @Column(name = "CHIPSET")
    private String chipset;

    @NotNull
    @Column(name = "COMPATIBLE_PROCESSORS")
    private String compatibleProcessors;

    @NotNull
    @Column(name = "SOUND_CHIP")
    private String soundChip;

    @NotNull
    @Column(name = "SOUND_CHANNEL_AMOUNT")
    private String soundChannelAmount;

    @NotNull
    @Column(name = "HDMI")
    private boolean hdmi;

    @NotNull
    @Column(name = "DISPLAY_PORT")
    private boolean displayPort;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "MAINBOARD_RAM_ID")
    private MainboardRAM mainboardRAM;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
