package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopScreenDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopScreen;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopScreenDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopScreenService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopScreenServiceImpl implements LaptopScreenService {

    @Autowired
    private LaptopScreenDao laptopScreenDao;

    @Override
    public LaptopScreenDTO save(LaptopScreenDTO laptopScreenDTO) {
        LaptopScreen laptopScreen = MappingHelper.map(laptopScreenDTO, LaptopScreen.class);
        LaptopScreen result = laptopScreenDao.save(laptopScreen);
        return MappingHelper.map(result, LaptopScreenDTO.class);
    }

    @Override
    public LaptopScreenDTO update(LaptopScreenDTO laptopScreenDTO) {
        if(laptopScreenDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SCREEN_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopScreenDTO);
        }
    }

    @Override
    public List<LaptopScreenDTO> findAll() {
        List<LaptopScreen> laptopScreenList = laptopScreenDao.findAll();
        return MappingHelper.mapList(laptopScreenList, LaptopScreenDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopScreen laptopScreen = getById(id);
        laptopScreenDao.delete(laptopScreen);
    }

    private LaptopScreen getById(Long id) {
        Optional<LaptopScreen> optionalLaptopScreen = laptopScreenDao.findById(id);
        return optionalLaptopScreen.orElse(null);
    }
}
