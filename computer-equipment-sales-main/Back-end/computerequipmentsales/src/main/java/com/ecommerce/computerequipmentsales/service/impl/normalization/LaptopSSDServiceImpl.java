package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopSSDDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopSSD;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopSSDDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopSSDService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopSSDServiceImpl implements LaptopSSDService {

    @Autowired
    private LaptopSSDDao laptopSSDDao;

    @Override
    public LaptopSSDDTO save(LaptopSSDDTO laptopSSDDTO) {
        LaptopSSD laptopSSD = MappingHelper.map(laptopSSDDTO, LaptopSSD.class);
        LaptopSSD result = laptopSSDDao.save(laptopSSD);
        return MappingHelper.map(result, LaptopSSDDTO.class);
    }

    @Override
    public LaptopSSDDTO update(LaptopSSDDTO laptopSSDDTO) {
        if(laptopSSDDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SSD_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopSSDDTO);
        }
    }

    @Override
    public List<LaptopSSDDTO> findAll() {
        List<LaptopSSD> laptopSSDList = laptopSSDDao.findAll();
        return MappingHelper.mapList(laptopSSDList, LaptopSSDDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopSSD laptopSSD = getById(id);
        laptopSSDDao.delete(laptopSSD);
    }

    private LaptopSSD getById(Long id) {
        Optional<LaptopSSD> optionalLaptopSSD = laptopSSDDao.findById(id);
        return optionalLaptopSSD.orElse(null);
    }
}
