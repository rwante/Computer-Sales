package com.ecommerce.computerequipmentsales.service.impl;

import com.ecommerce.computerequipmentsales.constants.BusinessRule;
import com.ecommerce.computerequipmentsales.dto.StockDTO;
import com.ecommerce.computerequipmentsales.entity.Stock;
import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.repository.StockDao;
import com.ecommerce.computerequipmentsales.service.StockService;
import com.ecommerce.computerequipmentsales.util.MappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    public StockDTO save(StockDTO stockDTO) {
        Stock stock = MappingHelper.map(stockDTO, Stock.class);
        Stock result = stockDao.save(stock);
        return MappingHelper.map(result, StockDTO.class);
    }

    @Override
    public StockDTO update(StockDTO stockDTO) {
        if(stockDTO.getId() == null){
            throw new ComputerEquipmentSalesBusinessException(BusinessRule.STOCK_NOT_FOUND.getDescription());
        }
        else{
            return save(stockDTO);
        }
    }

    @Override
    public List<StockDTO> findAll() {
        List<Stock> stockList = stockDao.findAll();
        return MappingHelper.mapList(stockList, StockDTO.class);
    }

    @Override
    public void delete(Long id) {
        Stock stock = getById(id);
        stockDao.delete(stock);
    }

    private Stock getById(Long id) {
        Optional<Stock> optionalStock = stockDao.findById(id);
        return optionalStock.orElse(null);
    }
}
