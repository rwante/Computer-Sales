package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.StockDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.STOCK_API_URL)
public class StockController {

    @Autowired
    private StockService stockService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", stockService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody StockDTO stockDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", stockService.save(stockDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        stockService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody StockDTO stockDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", stockService.update(stockDTO));
    }
}
