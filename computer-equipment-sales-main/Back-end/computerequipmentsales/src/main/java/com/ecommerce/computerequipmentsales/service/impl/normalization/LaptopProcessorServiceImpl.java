package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopProcessorDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopProcessor;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopProcessorDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopProcessorService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopProcessorServiceImpl implements LaptopProcessorService {

    @Autowired
    private LaptopProcessorDao laptopProcessorDao;

    @Override
    public LaptopProcessorDTO save(LaptopProcessorDTO laptopProcessorDTO) {
        LaptopProcessor laptopProcessor = MappingHelper.map(laptopProcessorDTO, LaptopProcessor.class);
        LaptopProcessor result = laptopProcessorDao.save(laptopProcessor);
        return MappingHelper.map(result, LaptopProcessorDTO.class);
    }

    @Override
    public LaptopProcessorDTO update(LaptopProcessorDTO laptopProcessorDTO) {
        if(laptopProcessorDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_PROCESSOR_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopProcessorDTO);
        }
    }

    @Override
    public List<LaptopProcessorDTO> findAll() {
        List<LaptopProcessor> laptopProcessorList = laptopProcessorDao.findAll();
        return MappingHelper.mapList(laptopProcessorList, LaptopProcessorDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopProcessor laptopProcessor = getById(id);
        laptopProcessorDao.delete(laptopProcessor);
    }

    private LaptopProcessor getById(Long id) {
        Optional<LaptopProcessor> optionalLaptopProcessor = laptopProcessorDao.findById(id);
        return optionalLaptopProcessor.orElse(null);
    }
}
