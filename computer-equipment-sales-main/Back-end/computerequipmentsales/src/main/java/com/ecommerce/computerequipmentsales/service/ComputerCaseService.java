package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.ComputerCaseDTO;

import java.util.List;

public interface ComputerCaseService {

    ComputerCaseDTO save(ComputerCaseDTO computerCaseDTO);

    ComputerCaseDTO update(ComputerCaseDTO computerCaseDTO);

    List<ComputerCaseDTO> findAll();

    void delete(Long id);
}
