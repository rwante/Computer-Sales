package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.SSDDTO;
import com.ecommerce.computerequipmentsales.entity.SSD;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.SSDDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.service.SSDService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SSDServiceImpl implements SSDService {

    @Autowired
    private SSDDao ssdDao;
    @Autowired
    private StockDao stockDao;

    private void validate(SSDDTO ssddto){
        if(ssddto.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.SSD_NOT_FOUND.getDescription());
        }
        if(ssddto.getStockId() == null || ssddto.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(SSDDTO ssddto){
        SSD ssdProductCode = ssdDao.findOneByProductCode(ssddto.getProductCode());
        if(Optional.ofNullable(ssdProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }
    private void validateRelation(SSDDTO ssddto){
        if(ssddto.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.SSD_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(ssddto.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    @Override
    public SSDDTO save(SSDDTO ssddto) {
        validate(ssddto);
        validateRelation(ssddto);
        validateCode(ssddto);
        SSD ssd = MappingHelper.map(ssddto, SSD.class);
        SSD result = ssdDao.save(ssd);
        return MappingHelper.map(result, SSDDTO.class);
    }

    @Override
    public SSDDTO update(SSDDTO ssddto) {
        if(ssddto.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.SSD_NOT_FOUND.getDescription());
        }
        else{
            SSD ssd = MappingHelper.map(ssddto, SSD.class);
            SSD result = ssdDao.save(ssd);
            return MappingHelper.map(result, SSDDTO.class);
        }
    }

    @Override
    public List<SSDDTO> findAll() {
        List<SSD> ssdList = ssdDao.findAll();
        return MappingHelper.mapList(ssdList, SSDDTO.class);
    }

    @Override
    public void delete(Long id) {
        SSD ssd = getById(id);
        ssdDao.delete(ssd);
    }

    private SSD getById(Long id) {
        Optional<SSD> optionalSSD = ssdDao.findById(id);
        return optionalSSD.orElse(null);
    }
}
