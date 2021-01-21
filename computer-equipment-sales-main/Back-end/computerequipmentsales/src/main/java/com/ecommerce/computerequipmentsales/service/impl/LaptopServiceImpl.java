package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.LaptopDTO;
import com.ecommerce.computerequipmentsales.entity.DisplayCard;
import com.ecommerce.computerequipmentsales.entity.Laptop;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.entity.normalization.*;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.LaptopDao;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.repository.normalization.*;
import com.ecommerce.computerequipmentsales.service.LaptopService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopDao laptopDao;
    @Autowired
    private LaptopScreenDao laptopScreenDao;
    @Autowired
    private LaptopSSDDao laptopSSDDao;
    @Autowired
    private LaptopHDDDao laptopHDDDao;
    @Autowired
    private LaptopGPUDao laptopGPUDao;
    @Autowired
    private LaptopProcessorDao laptopProcessorDao;
    @Autowired
    private LaptopRAMDao laptopRAMDao;
    @Autowired
    private StockDao stockDao;

    private void validate(LaptopDTO laptopDTO){
        if(laptopDTO.getBrand() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopScreenId() == null || laptopDTO.getLaptopScreenId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SCREEN_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopSSDId() == null || laptopDTO.getLaptopSSDId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SSD_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopHDDId() == null || laptopDTO.getLaptopHDDId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_HDD_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopGPUId() == null || laptopDTO.getLaptopGPUId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_GPU_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopProcessorId() == null || laptopDTO.getLaptopProcessorId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_PROCESSOR_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getLaptopRAMId() == null || laptopDTO.getLaptopRAMId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_RAM_NOT_FOUND.getDescription());
        }
        if(laptopDTO.getStockId() == null || laptopDTO.getStockId() < 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    private void validateCode(LaptopDTO laptopDTO){
        Laptop laptopProductCode = laptopDao.findOneByProductCode(laptopDTO.getProductCode());
        if(Optional.ofNullable(laptopProductCode).isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.PRODUCT_CODE_IS_USING.getDescription());
        }
    }

    private void validateRelation(LaptopDTO laptopDTO){
        if(laptopDTO.getPrice() <= 0){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_NOT_FOUND.getDescription());
        }
        Optional<LaptopScreen> optionalLaptopScreen = laptopScreenDao.findById(laptopDTO.getLaptopScreenId());
        if(!optionalLaptopScreen.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SCREEN_NOT_FOUND.getDescription());
        }
        Optional<LaptopSSD> optionalLaptopSSD = laptopSSDDao.findById(laptopDTO.getLaptopSSDId());
        if(!optionalLaptopSSD.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_SSD_NOT_FOUND.getDescription());
        }
        Optional<LaptopHDD> optionalLaptopHDD = laptopHDDDao.findById(laptopDTO.getLaptopHDDId());
        if(!optionalLaptopHDD.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_HDD_NOT_FOUND.getDescription());
        }
        Optional<LaptopGPU> optionalLaptopGPU = laptopGPUDao.findById(laptopDTO.getLaptopGPUId());
        if(!optionalLaptopGPU.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_GPU_NOT_FOUND.getDescription());
        }
        Optional<LaptopProcessor> optionalLaptopProcessor = laptopProcessorDao.findById(laptopDTO.getLaptopProcessorId());
        if(!optionalLaptopProcessor.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_PROCESSOR_NOT_FOUND.getDescription());
        }
        Optional<LaptopRAM> optionalLaptopRAM = laptopRAMDao.findById(laptopDTO.getLaptopRAMId());
        if(!optionalLaptopRAM.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_RAM_NOT_FOUND.getDescription());
        }
        Optional<Stock> optionalStock = stockDao.findById(laptopDTO.getStockId());
        if(!optionalStock.isPresent()){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
    }

    @Override
    public LaptopDTO save(LaptopDTO laptopDTO) {
        validate(laptopDTO);
        validateRelation(laptopDTO);
        validateCode(laptopDTO);
        Laptop laptop = MappingHelper.map(laptopDTO, Laptop.class);
        Laptop result = laptopDao.save(laptop);
        return MappingHelper.map(result, LaptopDTO.class);
    }

    @Override
    public LaptopDTO update(LaptopDTO laptopDTO) {
        validateRelation(laptopDTO);
        if(laptopDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.LAPTOP_NOT_FOUND.getDescription());
        }
        else{
            Laptop laptop = MappingHelper.map(laptopDTO, Laptop.class);
            Laptop result = laptopDao.save(laptop);
            return MappingHelper.map(result, LaptopDTO.class);
        }
    }

    @Override
    public List<LaptopDTO> findAll() {
        List<Laptop> laptopList = laptopDao.findAll();
        return MappingHelper.mapList(laptopList, LaptopDTO.class);
    }

    @Override
    public void delete(Long id) {
        Laptop laptop = getById(id);
        laptopDao.delete(laptop);
    }

    private Laptop getById(Long id) {
        Optional<Laptop> optionalLaptop = laptopDao.findById(id);
        return optionalLaptop.orElse(null);
    }
}
