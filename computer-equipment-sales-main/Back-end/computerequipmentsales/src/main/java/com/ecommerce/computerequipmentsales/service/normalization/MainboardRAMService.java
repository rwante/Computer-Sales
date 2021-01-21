package com.ecommerce.computerequipmentsales.service.normalization;


import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MainboardRAMDTO;

import java.util.List;

public interface MainboardRAMService {

    MainboardRAMDTO save(MainboardRAMDTO mainboardRAMDTO);

    MainboardRAMDTO update(MainboardRAMDTO mainboardRAMDTO);

    List<MainboardRAMDTO> findAll();

    void delete(Long id);
}
