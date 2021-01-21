package com.ecommerce.computerequipmentsales.service.normalization;


import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopScreenDTO;

import java.util.List;

public interface LaptopScreenService {

    LaptopScreenDTO save(LaptopScreenDTO laptopScreenDTO);

    LaptopScreenDTO update(LaptopScreenDTO laptopScreenDTO);

    List<LaptopScreenDTO> findAll();

    void delete(Long id);
}
