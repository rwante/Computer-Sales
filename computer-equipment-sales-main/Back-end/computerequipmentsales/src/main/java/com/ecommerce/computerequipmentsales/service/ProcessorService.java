package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.ProcessorDTO;

import java.util.List;

public interface ProcessorService {

    ProcessorDTO save(ProcessorDTO processorDTO);

    ProcessorDTO update(ProcessorDTO processorDTO);

    List<ProcessorDTO> findAll();

    void delete(Long id);
}
