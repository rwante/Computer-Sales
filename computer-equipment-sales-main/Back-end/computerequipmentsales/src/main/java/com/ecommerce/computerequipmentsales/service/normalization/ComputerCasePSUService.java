package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.ComputerCasePSUDTO;

import java.util.List;

public interface ComputerCasePSUService {

    ComputerCasePSUDTO save(ComputerCasePSUDTO computerCasePSUDTO);

    ComputerCasePSUDTO update(ComputerCasePSUDTO computerCaseDTO);

    List<ComputerCasePSUDTO> findAll();

    ComputerCasePSUDTO findOne(Long id);

    void delete(Long id);
}
