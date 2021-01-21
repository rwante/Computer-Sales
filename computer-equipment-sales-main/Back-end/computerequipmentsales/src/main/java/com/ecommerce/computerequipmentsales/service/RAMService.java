package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.RAMDTO;

import java.util.List;

public interface RAMService {

    RAMDTO save(RAMDTO ramdto);

    RAMDTO update(RAMDTO ramdto);

    List<RAMDTO> findAll();

    void delete(Long id);
}
