package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopHDDDTO;

import java.util.List;

public interface LaptopHDDService {

    LaptopHDDDTO save(LaptopHDDDTO laptopHDDDTO);

    LaptopHDDDTO update(LaptopHDDDTO laptopHDDDTO);

    List<LaptopHDDDTO> findAll();

    void delete(Long id);
}
