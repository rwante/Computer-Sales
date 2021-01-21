package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.MainboardDTO;
import com.ecommerce.computerequipmentsales.entity.DisplayCard;
import com.ecommerce.computerequipmentsales.entity.Mainboard;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.MainboardRAM;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.MainboardDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.MainboardRAMDao;
import com.ecommerce.computerequipmentsales.service.MainboardService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainboardServiceImpl implements MainboardService {

    @Autowired
    private MainboardDao mainboardDao;
    @Autowired
    private MainboardRAMDao mainboardRAMDao;
    @Autowired
    private StockDao stockDao;

    private void validate(MainboardDTO mainboardDTO){
        if(mainboardDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_NOT_FOUND.getDescription());
        }
        if(mainboardDTO.getMainboardRAMId() == null || mainboardDTO.getMainboardRAMId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_RAM_NOT_FOUND.getDescription());
        }
        if(mainboardDTO.getStockId() == null || mainboardDTO.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(MainboardDTO mainboardDTO){
        Mainboard mainboardProductCode = mainboardDao.findOneByProductCode(mainboardDTO.getProductCode());
        if(Optional.ofNullable(mainboardProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(MainboardDTO mainboardDTO){
        if(mainboardDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_NOT_FOUND.getDescription());
        }
        Optional<MainboardRAM> optionalMainboardRAM = mainboardRAMDao.findById(mainboardDTO.getMainboardRAMId());
        if(!optionalMainboardRAM.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_RAM_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(mainboardDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }
    @Override
    public MainboardDTO save(MainboardDTO mainboardDTO) {
        validate(mainboardDTO);
        validateRelation(mainboardDTO);
        validateCode(mainboardDTO);
        Mainboard mainboard = MappingHelper.map(mainboardDTO, Mainboard.class);
        Mainboard result = mainboardDao.save(mainboard);
        return MappingHelper.map(result, MainboardDTO.class);
    }

    @Override
    public MainboardDTO update(MainboardDTO mainboardDTO) {
        validateRelation(mainboardDTO);
        if(mainboardDTO.getId() == null){
                throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_NOT_FOUND.getDescription());
        }
        else{
            Mainboard mainboard = MappingHelper.map(mainboardDTO, Mainboard.class);
            Mainboard result = mainboardDao.save(mainboard);
            return MappingHelper.map(result, MainboardDTO.class);
        }
    }

    @Override
    public List<MainboardDTO> findAll() {
        List<Mainboard> mainboardList = mainboardDao.findAll();
        return MappingHelper.mapList(mainboardList, MainboardDTO.class);
    }

    @Override
    public void delete(Long id) {
        Mainboard mainboard = getById(id);
        mainboardDao.delete(mainboard);
    }

    private Mainboard getById(Long id) {
        Optional<Mainboard> optionalMainboard = mainboardDao.findById(id);
        return optionalMainboard.orElse(null);
    }
}
