package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.DisplayCardDTO;

import java.util.List;

public interface DisplayCardService {

    DisplayCardDTO save(DisplayCardDTO displayCardDTO);

    DisplayCardDTO update(DisplayCardDTO displayCardDTO);

    List<DisplayCardDTO> findAll();

    void delete(Long id);
}
