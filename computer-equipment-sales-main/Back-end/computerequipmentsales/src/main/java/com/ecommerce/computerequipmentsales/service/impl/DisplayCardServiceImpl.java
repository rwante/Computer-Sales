package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.DisplayCardDTO;
import com.ecommerce.computerequipmentsales.entity.ComputerCase;
import com.ecommerce.computerequipmentsales.entity.DisplayCard;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardGPU;
import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardMemory;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.DisplayCardDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.DisplayCardGPUDao;
import com.ecommerce.computerequipmentsales.repository.normalization.DisplayCardMemoryDao;
import com.ecommerce.computerequipmentsales.service.DisplayCardService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DisplayCardServiceImpl implements DisplayCardService {

    @Autowired
    private DisplayCardDao displayCardDao;
    @Autowired
    private DisplayCardGPUDao displayCardGPUDao;
    @Autowired
    private DisplayCardMemoryDao displayCardMemoryDao;
    @Autowired
    private StockDao stockDao;

    private void validate(DisplayCardDTO displayCardDTO){
        if(displayCardDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_NOT_FOUND.getDescription());
        }
        if(displayCardDTO.getDisplayCardGPUId() == null || displayCardDTO.getDisplayCardGPUId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_GPU_NOT_FOUND.getDescription());
        }
        if(displayCardDTO.getDisplayCardMemoryId() == null || displayCardDTO.getDisplayCardMemoryId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_MEMORY_NOT_FOUND.getDescription());
        }
        if(displayCardDTO.getStockId() == null || displayCardDTO.getStockId() <0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(DisplayCardDTO displayCardDTO){
        DisplayCard displayCardProductCode = displayCardDao.findOneByProductCode(displayCardDTO.getProductCode());
        if(Optional.ofNullable(displayCardProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }
    private void validateRelation(DisplayCardDTO displayCardDTO){
        Optional<DisplayCardGPU> optionalDisplayCardGPU = displayCardGPUDao.findById(displayCardDTO.getDisplayCardGPUId());
        if(!optionalDisplayCardGPU.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_GPU_NOT_FOUND.getDescription());
        }
        Optional<DisplayCardMemory> optionalDisplayCardMemory = displayCardMemoryDao.findById(displayCardDTO.getDisplayCardMemoryId());
        if(!optionalDisplayCardMemory.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_MEMORY_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(displayCardDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
        if(displayCardDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_NOT_FOUND.getDescription());
        }
    }

    @Override
    public DisplayCardDTO save(DisplayCardDTO displayCardDTO) {
        validate(displayCardDTO);
        validateRelation(displayCardDTO);
        validateCode(displayCardDTO);
        DisplayCard displayCard = MappingHelper.map(displayCardDTO, DisplayCard.class);
        DisplayCard result = displayCardDao.save(displayCard);
        return MappingHelper.map(result, DisplayCardDTO.class);
    }

    @Override
    public DisplayCardDTO update(DisplayCardDTO displayCardDTO) {
        validateRelation(displayCardDTO);
        if(displayCardDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_NOT_FOUND.getDescription());
        }
        else{
            DisplayCard displayCard = MappingHelper.map(displayCardDTO, DisplayCard.class);
            DisplayCard result = displayCardDao.save(displayCard);
            return MappingHelper.map(result, DisplayCardDTO.class);
        }
    }

    @Override
    public List<DisplayCardDTO> findAll() {
        List<DisplayCard> displayCardList = displayCardDao.findAll();
        return MappingHelper.mapList(displayCardList, DisplayCardDTO.class);
    }

    @Override
    public void delete(Long id) {
        DisplayCard displayCard = getById(id);
        displayCardDao.delete(displayCard);
    }

    private DisplayCard getById(Long id) {
        Optional<DisplayCard> optionalDisplayCard = displayCardDao.findById(id);
        return optionalDisplayCard.orElse(null);
    }
}
