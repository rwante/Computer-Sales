package com.ecommerce.computerequipmentsales.service.normalization;


import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopRAMDTO;

import java.util.List;

public interface LaptopRAMService {

    LaptopRAMDTO save(LaptopRAMDTO laptopRAMDTO);

    LaptopRAMDTO update(LaptopRAMDTO laptopRAMDTO);

    List<LaptopRAMDTO> findAll();

    void delete(Long id);
}
