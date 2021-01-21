package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.StockDTO;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardGPUDTO;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardGPU;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.DisplayCardGPUDao;
import com.ecommerce.computerequipmentsales.service.normalization.DisplayCardGPUService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DisplayCardGPUServiceImpl implements DisplayCardGPUService {

    @Autowired
    private DisplayCardGPUDao displayCardGPUDao;

    @Override
    public DisplayCardGPUDTO save(DisplayCardGPUDTO displayCardGPUDTO) {
        DisplayCardGPU displayCardGPU = MappingHelper.map(displayCardGPUDTO, DisplayCardGPU.class);
        DisplayCardGPU result = displayCardGPUDao.save(displayCardGPU);
        return MappingHelper.map(result, DisplayCardGPUDTO.class);
    }

    @Override
    public DisplayCardGPUDTO update(DisplayCardGPUDTO displayCardGPUDTO) {
        if(displayCardGPUDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_GPU_NOT_FOUND.getDescription());
        }
        else{
            return save(displayCardGPUDTO);
        }
    }

    @Override
    public List<DisplayCardGPUDTO> findAll() {
        List<DisplayCardGPU> displayCardGPUList = displayCardGPUDao.findAll();
        return MappingHelper.mapList(displayCardGPUList, DisplayCardGPUDTO.class);
    }

    @Override
    public void delete(Long id) {
        DisplayCardGPU displayCardGPU = getById(id);
        displayCardGPUDao.delete(displayCardGPU);
    }

    private DisplayCardGPU getById(Long id) {
        Optional<DisplayCardGPU> optionalDisplayCardGPU = displayCardGPUDao.findById(id);
        return optionalDisplayCardGPU.orElse(null);
    }
}
