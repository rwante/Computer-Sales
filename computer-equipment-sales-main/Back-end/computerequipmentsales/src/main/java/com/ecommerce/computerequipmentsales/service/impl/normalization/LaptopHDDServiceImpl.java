package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopHDDDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopHDD;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopHDDDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopHDDService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopHDDServiceImpl implements LaptopHDDService {

    @Autowired
    private LaptopHDDDao laptopHDDDao;

    @Override
    public LaptopHDDDTO save(LaptopHDDDTO laptopHDDDTO) {
        LaptopHDD laptopHDD = MappingHelper.map(laptopHDDDTO, LaptopHDD.class);
        LaptopHDD result = laptopHDDDao.save(laptopHDD);
        return MappingHelper.map(result, LaptopHDDDTO.class);
    }

    @Override
    public LaptopHDDDTO update(LaptopHDDDTO laptopHDDDTO) {
        if(laptopHDDDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_HDD_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopHDDDTO);
        }
    }

    @Override
    public List<LaptopHDDDTO> findAll() {
        List<LaptopHDD> laptopHDDList = laptopHDDDao.findAll();
        return MappingHelper.mapList(laptopHDDList, LaptopHDDDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopHDD laptopHDD = getById(id);
        laptopHDDDao.delete(laptopHDD);
    }

    private LaptopHDD getById(Long id) {
        Optional<LaptopHDD> optionalLaptopHDD = laptopHDDDao.findById(id);
        return optionalLaptopHDD.orElse(null);
    }
}
