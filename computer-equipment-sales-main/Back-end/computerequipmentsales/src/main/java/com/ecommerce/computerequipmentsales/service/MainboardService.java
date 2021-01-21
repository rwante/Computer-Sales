package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.MainboardDTO;

import java.util.List;

public interface MainboardService {

    MainboardDTO save(MainboardDTO mainboardDTO);

    MainboardDTO update(MainboardDTO mainboardDTO);

    List<MainboardDTO> findAll();

    void delete(Long id);
}
