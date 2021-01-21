package com.ecommerce.computerequipmentsales.entity;

import com.ecommerce.computerequipmentsales.entity.normalization.MonitorScreen;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Monitor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "REFRESH_SPEED")
    private String refreshSpeed;

    @NotNull
    @Column(name = "HDR")
    private boolean hdr;

    @NotNull
    @Column(name = "REACTION_TIME")
    private String reactionTime;

    @NotNull
    @Column(name = "OUTPUTS")
    private String outputs;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "MONITOR_SCREEN_ID")
    private MonitorScreen monitorScreen;

    @NotNull
    @OneToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}
