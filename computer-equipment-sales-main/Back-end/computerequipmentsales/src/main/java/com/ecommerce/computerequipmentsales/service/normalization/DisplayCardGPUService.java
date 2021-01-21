package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardGPUDTO;

import java.util.List;

public interface DisplayCardGPUService {

    DisplayCardGPUDTO save(DisplayCardGPUDTO displayCardGPUDTO);

    DisplayCardGPUDTO update(DisplayCardGPUDTO displayCardGPUDTO);

    List<DisplayCardGPUDTO> findAll();

    void delete(Long id);
}
