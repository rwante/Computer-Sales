package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopGPUDTO;

import java.util.List;

public interface LaptopGPUService {

    LaptopGPUDTO save(LaptopGPUDTO laptopGPUDTO);

    LaptopGPUDTO update(LaptopGPUDTO laptopGPUDTO);

    List<LaptopGPUDTO> findAll();

    void delete(Long id);
}
