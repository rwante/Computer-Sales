package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardMemoryDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.DisplayCardMemory;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.DisplayCardMemoryDao;
import com.ecommerce.computerequipmentsales.service.normalization.DisplayCardMemoryService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DisplayCardMemoryServiceImpl implements DisplayCardMemoryService {

    @Autowired
    private DisplayCardMemoryDao displayCardMemoryDao;

    @Override
    public DisplayCardMemoryDTO save(DisplayCardMemoryDTO displayCardMemoryDTO) {
        DisplayCardMemory displayCardMemory = MappingHelper.map(displayCardMemoryDTO, DisplayCardMemory.class);
        DisplayCardMemory result = displayCardMemoryDao.save(displayCardMemory);
        return MappingHelper.map(result, DisplayCardMemoryDTO.class);
    }

    @Override
    public DisplayCardMemoryDTO update(DisplayCardMemoryDTO displayCardMemoryDTO) {
        if(displayCardMemoryDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.DISPLAY_CARD_MEMORY_NOT_FOUND.getDescription());
        }
        else{
            return save(displayCardMemoryDTO);
        }
    }

    @Override
    public List<DisplayCardMemoryDTO> findAll() {
        List<DisplayCardMemory> displayCardMemoryList = displayCardMemoryDao.findAll();
        return MappingHelper.mapList(displayCardMemoryList, DisplayCardMemoryDTO.class);
    }

    @Override
    public void delete(Long id) {
        DisplayCardMemory displayCardMemory = getById(id);
        displayCardMemoryDao.delete(displayCardMemory);
    }

    private DisplayCardMemory getById(Long id) {
        Optional<DisplayCardMemory> optionalDisplayCardMemory = displayCardMemoryDao.findById(id);
        return optionalDisplayCardMemory.orElse(null);
    }
}
