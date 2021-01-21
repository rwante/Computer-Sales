package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopSSDDTO;

import java.util.List;

public interface LaptopSSDService {

    LaptopSSDDTO save(LaptopSSDDTO laptopSSDDTO);

    LaptopSSDDTO update(LaptopSSDDTO laptopSSDDTO);

    List<LaptopSSDDTO> findAll();

    void delete(Long id);
}
