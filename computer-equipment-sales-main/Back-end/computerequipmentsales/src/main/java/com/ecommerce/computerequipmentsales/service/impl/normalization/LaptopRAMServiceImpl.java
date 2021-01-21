package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopRAMDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopRAM;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopRAMDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopRAMService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopRAMServiceImpl implements LaptopRAMService {

    @Autowired
    private LaptopRAMDao laptopRAMDao;

    @Override
    public LaptopRAMDTO save(LaptopRAMDTO laptopRAMDTO) {
        LaptopRAM laptopRAM = MappingHelper.map(laptopRAMDTO, LaptopRAM.class);
        LaptopRAM result = laptopRAMDao.save(laptopRAM);
        return MappingHelper.map(result, LaptopRAMDTO.class);
    }

    @Override
    public LaptopRAMDTO update(LaptopRAMDTO laptopRAMDTO) {
        if(laptopRAMDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_RAM_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopRAMDTO);
        }
    }

    @Override
    public List<LaptopRAMDTO> findAll() {
        List<LaptopRAM> laptopRAMList = laptopRAMDao.findAll();
        return MappingHelper.mapList(laptopRAMList, LaptopRAMDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopRAM laptopRAM = getById(id);
        laptopRAMDao.delete(laptopRAM);
    }

    private LaptopRAM getById(Long id) {
        Optional<LaptopRAM> optionalLaptopRAM = laptopRAMDao.findById(id);
        return optionalLaptopRAM.orElse(null);
    }
}
