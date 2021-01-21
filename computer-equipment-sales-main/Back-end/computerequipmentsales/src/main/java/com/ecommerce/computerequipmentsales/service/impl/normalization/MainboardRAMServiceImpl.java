package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MainboardRAMDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.MainboardRAM;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.MainboardRAMDao;
import com.ecommerce.computerequipmentsales.service.normalization.MainboardRAMService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainboardRAMServiceImpl implements MainboardRAMService {

    @Autowired
    private MainboardRAMDao mainboardRAMDao;

    @Override
    public MainboardRAMDTO save(MainboardRAMDTO mainboardRAMDTO) {
        MainboardRAM mainboardRAM = MappingHelper.map(mainboardRAMDTO, MainboardRAM.class);
        MainboardRAM result = mainboardRAMDao.save(mainboardRAM);
        return MappingHelper.map(result, MainboardRAMDTO.class);
    }

    @Override
    public MainboardRAMDTO update(MainboardRAMDTO mainboardRAMDTO) {
        if(mainboardRAMDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.MAINBOARD_RAM_NOT_FOUND.getDescription());
        }
        else{
            return save(mainboardRAMDTO);
        }
    }

    @Override
    public List<MainboardRAMDTO> findAll() {
        List<MainboardRAM> mainboardRAMList = mainboardRAMDao.findAll();
        return MappingHelper.mapList(mainboardRAMList, MainboardRAMDTO.class);
    }

    @Override
    public void delete(Long id) {
        MainboardRAM mainboardRAM = getById(id);
        mainboardRAMDao.delete(mainboardRAM);
    }

    private MainboardRAM getById(Long id) {
        Optional<MainboardRAM> optionalMainboardRAM = mainboardRAMDao.findById(id);
        return optionalMainboardRAM.orElse(null);
    }
}
