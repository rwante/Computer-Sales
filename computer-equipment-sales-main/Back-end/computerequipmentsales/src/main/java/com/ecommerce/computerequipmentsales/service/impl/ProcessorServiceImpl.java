package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.ProcessorDTO;
import com.ecommerce.computerequipmentsales.entity.Processor;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.ProcessorCore;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.ProcessorDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.ProcessorCoreDao;
import com.ecommerce.computerequipmentsales.service.ProcessorService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProcessorServiceImpl implements ProcessorService {

    @Autowired
    private ProcessorDao processorDao;
    @Autowired
    private ProcessorCoreDao processorCoreDao;
    @Autowired
    private StockDao stockDao;

    private void validate(ProcessorDTO processorDTO){
        if(processorDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_NOT_FOUND.getDescription());
        }
        if(processorDTO.getProcessorCoreId() == null || processorDTO.getProcessorCoreId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_CORE_NOT_FOUND.getDescription());
        }
        if(processorDTO.getStockId() == null || processorDTO.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(ProcessorDTO processorDTO){
        Processor processorProductCode = processorDao.findOneByProductCode(processorDTO.getProductCode());
        if(Optional.ofNullable(processorProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }
    private void validateRelation(ProcessorDTO processorDTO){
        if(processorDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_NOT_FOUND.getDescription());
        }
        Optional<ProcessorCore> optionalProcessorCore = processorCoreDao.findById(processorDTO.getProcessorCoreId());
        if(!optionalProcessorCore.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_CORE_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(processorDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    @Override
    public ProcessorDTO save(ProcessorDTO processorDTO) {
        validate(processorDTO);
        validateRelation(processorDTO);
        validateCode(processorDTO);
        Processor processor = MappingHelper.map(processorDTO, Processor.class);
        Processor result = processorDao.save(processor);
        return MappingHelper.map(result, ProcessorDTO.class);
    }

    @Override
    public ProcessorDTO update(ProcessorDTO processorDTO) {
        validateRelation(processorDTO);
        if(processorDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_NOT_FOUND.getDescription());
        }
        else{
            Processor processor = MappingHelper.map(processorDTO, Processor.class);
            Processor result = processorDao.save(processor);
            return MappingHelper.map(result, ProcessorDTO.class);        }
    }

    @Override
    public List<ProcessorDTO> findAll() {
        List<Processor> processorList = processorDao.findAll();
        return MappingHelper.mapList(processorList, ProcessorDTO.class);
    }

    @Override
    public void delete(Long id) {
        Processor processor = getById(id);
        processorDao.delete(processor);
    }

    private Processor getById(Long id) {
        Optional<Processor> optionalProcessor = processorDao.findById(id);
        return optionalProcessor.orElse(null);
    }
}
