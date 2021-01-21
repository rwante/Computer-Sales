package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.ProcessorCoreDTO;

import java.util.List;

public interface ProcessorCoreService {

    ProcessorCoreDTO save(ProcessorCoreDTO processorCoreDTO);

    ProcessorCoreDTO update(ProcessorCoreDTO processorCoreDTO);

    List<ProcessorCoreDTO> findAll();

    void delete(Long id);
}
