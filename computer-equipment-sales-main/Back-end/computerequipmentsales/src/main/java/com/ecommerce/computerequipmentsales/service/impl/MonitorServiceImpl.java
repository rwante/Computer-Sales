package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.MonitorDTO;
import com.ecommerce.computerequipmentsales.entity.Monitor;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.MonitorScreen;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.MonitorDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.MonitorScreenDao;
import com.ecommerce.computerequipmentsales.service.MonitorService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorDao monitorDao;
    @Autowired
    private MonitorScreenDao monitorScreenDao;
    @Autowired
    private StockDao stockDao;

    private void validate(MonitorDTO monitorDTO){
        if(monitorDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_NOT_FOUND.getDescription());
        }
        if(monitorDTO.getMonitorScreenId() == null || monitorDTO.getMonitorScreenId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_SCREEN_NOT_FOUND.getDescription());
        }
        if(monitorDTO.getStockId() == null || monitorDTO.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(MonitorDTO monitorDTO){
        Monitor monitorProductCode = monitorDao.findOneByProductCode(monitorDTO.getProductCode());
        if(Optional.ofNullable(monitorProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(MonitorDTO monitorDTO){
        if(monitorDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_NOT_FOUND.getDescription());
        }
        Optional<MonitorScreen> optionalMonitorScreen = monitorScreenDao.findById(monitorDTO.getMonitorScreenId());
        if(!optionalMonitorScreen.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_SCREEN_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(monitorDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }
    @Override
    public MonitorDTO save(MonitorDTO monitorDTO) {
        validate(monitorDTO);
        validateRelation(monitorDTO);
        validateCode(monitorDTO);
        Monitor monitor = MappingHelper.map(monitorDTO, Monitor.class);
        Monitor result = monitorDao.save(monitor);
        return MappingHelper.map(result, MonitorDTO.class);
    }

    @Override
    public MonitorDTO update(MonitorDTO monitorDTO) {
        validateRelation(monitorDTO);
        if(monitorDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MONITOR_NOT_FOUND.getDescription());
        }
        else{
            Monitor monitor = MappingHelper.map(monitorDTO, Monitor.class);
            Monitor result = monitorDao.save(monitor);
            return MappingHelper.map(result, MonitorDTO.class);
        }
    }

    @Override
    public List<MonitorDTO> findAll() {
        List<Monitor> monitorList = monitorDao.findAll();
        return MappingHelper.mapList(monitorList, MonitorDTO.class);
    }

    @Override
    public void delete(Long id) {
        Monitor monitor = getById(id);
        monitorDao.delete(monitor);
    }

    private Monitor getById(Long id) {
        Optional<Monitor> optionalMonitor = monitorDao.findById(id);
        return optionalMonitor.orElse(null);
    }
}
