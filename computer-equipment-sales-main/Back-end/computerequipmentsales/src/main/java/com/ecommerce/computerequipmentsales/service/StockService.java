package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.StockDTO;

import java.util.List;

public interface StockService {

    StockDTO save(StockDTO stockDTO);

    StockDTO update(StockDTO stockDTO);

    List<StockDTO> findAll();

    void delete(Long id);
}
