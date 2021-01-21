package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardMemoryDTO;

import java.util.List;

public interface DisplayCardMemoryService {

    DisplayCardMemoryDTO save(DisplayCardMemoryDTO displayCardMemoryDTO);

    DisplayCardMemoryDTO update(DisplayCardMemoryDTO displayCardMemoryDTO);

    List<DisplayCardMemoryDTO> findAll();

    void delete(Long id);
}
