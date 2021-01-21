package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.SSDDTO;

import java.util.List;

public interface SSDService {

    SSDDTO save(SSDDTO ssddto);

    SSDDTO update(SSDDTO ssddto);

    List<SSDDTO> findAll();

    void delete(Long id);
}
