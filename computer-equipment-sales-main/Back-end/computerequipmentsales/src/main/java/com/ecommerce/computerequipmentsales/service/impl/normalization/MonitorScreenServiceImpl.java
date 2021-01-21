package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MonitorScreenDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.MonitorScreen;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.MonitorScreenDao;
import com.ecommerce.computerequipmentsales.service.normalization.MonitorScreenService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitorScreenServiceImpl implements MonitorScreenService {

    @Autowired
    private MonitorScreenDao monitorScreenDao;

    @Override
    public MonitorScreenDTO save(MonitorScreenDTO monitorScreenDTO) {
        MonitorScreen monitorScreen = MappingHelper.map(monitorScreenDTO, MonitorScreen.class);
        MonitorScreen result = monitorScreenDao.save(monitorScreen);
        return MappingHelper.map(result, MonitorScreenDTO.class);
    }

    @Override
    public MonitorScreenDTO update(MonitorScreenDTO monitorScreenDTO) {
        if(monitorScreenDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_SCREEN_NOT_FOUND.getDescription());
        }
        else{
            return save(monitorScreenDTO);
        }
    }

    @Override
    public List<MonitorScreenDTO> findAll() {
        List<MonitorScreen> monitorScreenList = monitorScreenDao.findAll();
        return MappingHelper.mapList(monitorScreenList, MonitorScreenDTO.class);
    }

    @Override
    public void delete(Long id) {
        MonitorScreen monitorScreen = getById(id);
        monitorScreenDao.delete(monitorScreen);
    }

    private MonitorScreen getById(Long id) {
        Optional<MonitorScreen> optionalMonitorScreen = monitorScreenDao.findById(id);
        return optionalMonitorScreen.orElse(null);
    }
}
