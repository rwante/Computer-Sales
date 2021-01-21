package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.LaptopDTO;

import java.util.List;

public interface LaptopService {

    LaptopDTO save(LaptopDTO laptopDTO);

    LaptopDTO update(LaptopDTO laptopDTO);

    List<LaptopDTO> findAll();

    void delete(Long id);
}
