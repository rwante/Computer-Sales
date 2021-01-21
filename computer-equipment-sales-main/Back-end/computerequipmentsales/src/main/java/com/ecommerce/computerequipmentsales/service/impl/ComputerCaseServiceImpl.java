package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.ComputerCaseDTO;
import com.ecommerce.computerequipmentsales.entity.ComputerCase;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.ComputerCasePSU;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.ComputerCaseDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.ComputerCasePSUDao;
import com.ecommerce.computerequipmentsales.service.ComputerCaseService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComputerCaseServiceImpl implements ComputerCaseService {

    @Autowired
    private ComputerCaseDao computerCaseDao;
    @Autowired
    private ComputerCasePSUDao computerCasePSUDao;
    @Autowired
    private StockDao stockDao;

    private void validate(ComputerCaseDTO computerCaseDTO){
        if(computerCaseDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_NOT_FOUND.getDescription());
        }
        if(computerCaseDTO.getComputerCasePsuId() == null || computerCaseDTO.getComputerCasePsuId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_PSU_NOT_FOUND.getDescription());
        }
        if(computerCaseDTO.getStockId() == null || computerCaseDTO.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(ComputerCaseDTO computerCaseDTO){
        ComputerCase computerCaseProductCode = computerCaseDao.findOneByProductCode(computerCaseDTO.getProductCode());
        if(Optional.ofNullable(computerCaseProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(ComputerCaseDTO computerCaseDTO){
        Optional<ComputerCasePSU> optionalComputerCasePSU = computerCasePSUDao.findById(computerCaseDTO.getComputerCasePsuId());
        if(!optionalComputerCasePSU.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_PSU_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(computerCaseDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
        if(computerCaseDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_NOT_FOUND.getDescription());
        }
    }

    @Override
    public ComputerCaseDTO save(ComputerCaseDTO computerCaseDTO) {
        validate(computerCaseDTO);
        validateRelation(computerCaseDTO);
        validateCode(computerCaseDTO);
        ComputerCase computerCase = MappingHelper.map(computerCaseDTO, ComputerCase.class);
        ComputerCase result = computerCaseDao.save(computerCase);
        return MappingHelper.map(result, ComputerCaseDTO.class);
    }

    @Override
    public ComputerCaseDTO update(ComputerCaseDTO computerCaseDTO) {
        validateRelation(computerCaseDTO);
        if(computerCaseDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_NOT_FOUND.getDescription());
        }
        else{
            ComputerCase computerCase = MappingHelper.map(computerCaseDTO, ComputerCase.class);
            ComputerCase result = computerCaseDao.save(computerCase);
            return MappingHelper.map(result, ComputerCaseDTO.class);
        }
    }

    @Override
    public List<ComputerCaseDTO> findAll() {
        List<ComputerCase> computerCaseList = computerCaseDao.findAll();
        return MappingHelper.mapList(computerCaseList, ComputerCaseDTO.class);
    }

    @Override
    public void delete(Long id) {
        ComputerCase computerCase = getById(id);
        computerCaseDao.delete(computerCase);
    }

    private ComputerCase getById(Long id) {
        Optional<ComputerCase> optionalComputerCase = computerCaseDao.findById(id);
        return optionalComputerCase.orElse(null);
    }
}
