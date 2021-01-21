package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopProcessorDTO;

import java.util.List;

public interface LaptopProcessorService {

    LaptopProcessorDTO save(LaptopProcessorDTO laptopProcessorDTO);

    LaptopProcessorDTO update(LaptopProcessorDTO laptopProcessorDTO);

    List<LaptopProcessorDTO> findAll();

    void delete(Long id);
}
