package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.HDDDTO;

import java.util.List;

public interface HDDService {

    HDDDTO save(HDDDTO hdddto);

    HDDDTO update(HDDDTO hdddto);

    List<HDDDTO> findAll();

    void delete(Long id);
}
