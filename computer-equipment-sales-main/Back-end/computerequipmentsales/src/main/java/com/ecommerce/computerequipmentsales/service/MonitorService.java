package com.ecommerce.computerequipmentsales.service;

import com.ecommerce.computerequipmentsales.dto.MonitorDTO;

import java.util.List;

public interface MonitorService {

    MonitorDTO save(MonitorDTO monitorDTO);

    MonitorDTO update(MonitorDTO monitorDTO);

    List<MonitorDTO> findAll();

    void delete(Long id);
}
