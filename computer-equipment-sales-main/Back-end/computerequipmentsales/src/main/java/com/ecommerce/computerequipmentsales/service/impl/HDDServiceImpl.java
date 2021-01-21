package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.HDDDTO;
import com.ecommerce.computerequipmentsales.entity.DisplayCard;
import com.ecommerce.computerequipmentsales.entity.HDD;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.HDDDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.service.HDDService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HDDServiceImpl implements HDDService {
    @Autowired
    private HDDDao hddDao;
    @Autowired
    private StockDao stockDao;

    private void validate(HDDDTO hdddto){
        if(hdddto.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.HDD_NOT_FOUND.getDescription());
        }
        if(hdddto.getStockId() == null || hdddto.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(HDDDTO hdddto){
        HDD hddProductCode = hddDao.findOneByProductCode(hdddto.getProductCode());
        if(Optional.ofNullable(hddProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(HDDDTO hdddto){
        Optional<Stock> optionalStock = stockDao.findById(hdddto.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
        if(hdddto.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.HDD_NOT_FOUND.getDescription());
        }
    }

    @Override
    public HDDDTO save(HDDDTO hdddto) {
        validate(hdddto);
        validateCode(hdddto);
        validateRelation(hdddto);
        HDD hdd = MappingHelper.map(hdddto, HDD.class);
        HDD result = hddDao.save(hdd);
        return MappingHelper.map(result, HDDDTO.class);
    }

    @Override
    public HDDDTO update(HDDDTO hdddto) {
        validateRelation(hdddto);
        if(hdddto.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.HDD_NOT_FOUND.getDescription());
        }
        else{
            HDD hdd = MappingHelper.map(hdddto, HDD.class);
            HDD result = hddDao.save(hdd);
            return MappingHelper.map(result, HDDDTO.class);
        }
    }

    @Override
    public List<HDDDTO> findAll() {
        List<HDD> hddList = hddDao.findAll();
        return MappingHelper.mapList(hddList, HDDDTO.class);
    }

    @Override
    public void delete(Long id) {
        HDD hdd = getById(id);
        hddDao.delete(hdd);
    }

    private HDD getById(Long id) {
        Optional<HDD> optionalHDD = hddDao.findById(id);
        return optionalHDD.orElse(null);
    }
}
