package com.ecommerce.computerequipmentsales.service.impl.normalization;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.ComputerCasePSUDTO;
import com.ecommerce.computerequipmentsales.entity.normalization.ComputerCasePSU;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.normalization.ComputerCasePSUDao;
import com.ecommerce.computerequipmentsales.service.normalization.ComputerCasePSUService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComputerCasePSUServiceImpl implements ComputerCasePSUService {

    @Autowired
    private ComputerCasePSUDao computerCasePSUDao;

    @Override
    public ComputerCasePSUDTO save(ComputerCasePSUDTO computerCasePSUDTO) {
        ComputerCasePSU computerCasePSU = MappingHelper.map(computerCasePSUDTO, ComputerCasePSU.class);
        ComputerCasePSU result = computerCasePSUDao.save(computerCasePSU);
        return MappingHelper.map(result, ComputerCasePSUDTO.class);
    }

    @Override
    public ComputerCasePSUDTO update(ComputerCasePSUDTO computerCasePSUDTO) {
        if(computerCasePSUDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_PSU_NOT_FOUND.getDescription());
        }
        else{
            return save(computerCasePSUDTO);
        }
    }

    @Override
    public List<ComputerCasePSUDTO> findAll() {
        List<ComputerCasePSU> computerCasePSUList = computerCasePSUDao.findAll();
        return MappingHelper.mapList(computerCasePSUList, ComputerCasePSUDTO.class);
    }

    @Override
    public ComputerCasePSUDTO findOne(Long id){
        Optional<ComputerCasePSU> optionalComputerCasePSU = computerCasePSUDao.findById(id);
        if(optionalComputerCasePSU.isPresent()){
            ComputerCasePSU computerCasePSU = optionalComputerCasePSU.get();
            return MappingHelper.map(computerCasePSU, ComputerCasePSUDTO.class);
        }
        else{
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.COMPUTER_CASE_PSU_NOT_FOUND.getDescription());
        }
    }

    @Override
    public void delete(Long id) {
        ComputerCasePSU computerCasePSU = getById(id);
        computerCasePSUDao.delete(computerCasePSU);
    }

    private ComputerCasePSU getById(Long id) {
        Optional<ComputerCasePSU> optionalComputerCasePSU = computerCasePSUDao.findById(id);
        return optionalComputerCasePSU.orElse(null);
    }
}
