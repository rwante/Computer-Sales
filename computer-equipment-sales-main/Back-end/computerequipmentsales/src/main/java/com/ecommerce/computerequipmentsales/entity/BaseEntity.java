package com.ecommerce.computerequipmentsales.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @NotNull
    @Column(name = "BRAND")
    private String brand;

    @NotNull
    @Column(name = "PRODUCT_CODE", unique = true, nullable = false)
    private String productCode;

    @NotNull
    @Column(name = "POINT_SCORING")
    private float pointScoring;

    @NotNull
    @Column(name = "PRICE")
    private float price;

}
