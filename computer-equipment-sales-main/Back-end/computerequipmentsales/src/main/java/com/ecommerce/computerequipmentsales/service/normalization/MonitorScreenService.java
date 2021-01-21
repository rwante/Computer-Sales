package com.ecommerce.computerequipmentsales.service.normalization;

import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MonitorScreenDTO;

import java.util.List;

public interface MonitorScreenService {

    MonitorScreenDTO save(MonitorScreenDTO monitorScreenDTO);

    MonitorScreenDTO update(MonitorScreenDTO monitorScreenDTO);

    List<MonitorScreenDTO> findAll();

    void delete(Long id);
}
