package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopGPUDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.LaptopGPU;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.LaptopGPUDao;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopGPUService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopGPUServiceImpl implements LaptopGPUService {

    @Autowired
    private LaptopGPUDao laptopGPUDao;

    @Override
    public LaptopGPUDTO save(LaptopGPUDTO laptopGPUDTO) {
        LaptopGPU laptopGPU = MappingHelper.map(laptopGPUDTO, LaptopGPU.class);
        LaptopGPU result = laptopGPUDao.save(laptopGPU);
        return MappingHelper.map(result, LaptopGPUDTO.class);
    }

    @Override
    public LaptopGPUDTO update(LaptopGPUDTO laptopGPUDTO) {
        if(laptopGPUDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_GPU_NOT_FOUND.getDescription());
        }
        else{
            return save(laptopGPUDTO);
        }
    }

    @Override
    public List<LaptopGPUDTO> findAll() {
        List<LaptopGPU> laptopGPUList = laptopGPUDao.findAll();
        return MappingHelper.mapList(laptopGPUList, LaptopGPUDTO.class);
    }

    @Override
    public void delete(Long id) {
        LaptopGPU laptopGPU = getById(id);
        laptopGPUDao.delete(laptopGPU);
    }

    private LaptopGPU getById(Long id) {
        Optional<LaptopGPU> optionalLaptopGPU = laptopGPUDao.findById(id);
        return optionalLaptopGPU.orElse(null);
    }
}
