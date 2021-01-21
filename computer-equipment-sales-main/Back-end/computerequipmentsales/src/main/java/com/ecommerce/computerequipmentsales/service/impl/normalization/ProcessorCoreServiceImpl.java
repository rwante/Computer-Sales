package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.ProcessorCoreDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.ProcessorCore;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.ProcessorCoreDao;
import com.ecommerce.computerequipmentsales.service.normalization.ProcessorCoreService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProcessorCoreServiceImpl implements ProcessorCoreService {

    @Autowired
    private ProcessorCoreDao processorCoreDao;

    @Override
    public ProcessorCoreDTO save(ProcessorCoreDTO processorCoreDTO) {
        ProcessorCore processorCore = MappingHelper.map(processorCoreDTO, ProcessorCore.class);
        ProcessorCore result = processorCoreDao.save(processorCore);
        return MappingHelper.map(result, ProcessorCoreDTO.class);
    }

    @Override
    public ProcessorCoreDTO update(ProcessorCoreDTO processorCoreDTO) {
        if(processorCoreDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PROCESSOR_CORE_NOT_FOUND.getDescription());
        }
        else{
            return save(processorCoreDTO);
        }
    }

    @Override
    public List<ProcessorCoreDTO> findAll() {
        List<ProcessorCore> processorCoreList = processorCoreDao.findAll();
        return MappingHelper.mapList(processorCoreList, ProcessorCoreDTO.class);
    }

    @Override
    public void delete(Long id) {
        ProcessorCore processorCore = getById(id);
        processorCoreDao.delete(processorCore);
    }

    private ProcessorCore getById(Long id) {
        Optional<ProcessorCore> optionalProcessorCore = processorCoreDao.findById(id);
        return optionalProcessorCore.orElse(null);
    }
}
