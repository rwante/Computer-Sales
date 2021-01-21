package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.RAMDTO;
import com.ecommerce.computerequipmentsales.entity.RAM;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.RAMDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.service.RAMService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RAMServiceImpl implements RAMService {

    @Autowired
    private RAMDao ramDao;
    @Autowired
    private StockDao stockDao;

    private void validate(RAMDTO ramdto){
        if(ramdto.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.RAM_NOT_FOUND.getDescription());
        }
        if(ramdto.getStockId() == null || ramdto.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(RAMDTO ramdto){
        RAM ramProductCode = ramDao.findOneByProductCode(ramdto.getProductCode());
        if(Optional.ofNullable(ramProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(RAMDTO ramdto){
        if(ramdto.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.RAM_NOT_FOUND.getDescription());
        }

        Optional<Stock> optionalStock = stockDao.findById(ramdto.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    @Override
    public RAMDTO save(RAMDTO ramdto) {
        validate(ramdto);
        validateRelation(ramdto);
        validateCode(ramdto);
        RAM ram = MappingHelper.map(ramdto, RAM.class);
        RAM result = ramDao.save(ram);
        return MappingHelper.map(result, RAMDTO.class);
    }

    @Override
    public RAMDTO update(RAMDTO ramdto) {
        validateRelation(ramdto);
        if(ramdto.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.RAM_NOT_FOUND.getDescription());
        }
        else{
            RAM ram = MappingHelper.map(ramdto, RAM.class);
            RAM result = ramDao.save(ram);
            return MappingHelper.map(result, RAMDTO.class);
        }
    }

    @Override
    public List<RAMDTO> findAll() {
        List<RAM> ramList = ramDao.findAll();
        return MappingHelper.mapList(ramList, RAMDTO.class);
    }

    @Override
    public void delete(Long id) {
        RAM ram = getById(id);
        ramDao.delete(ram);
    }

    private RAM getById(Long id) {
        Optional<RAM> optionalRAM = ramDao.findById(id);
        return optionalRAM.orElse(null);
    }
}
