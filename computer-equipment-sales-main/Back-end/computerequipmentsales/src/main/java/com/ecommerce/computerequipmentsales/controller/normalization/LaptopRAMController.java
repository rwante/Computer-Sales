package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopRAMDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopRAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_RAM_API_URL)
public class LaptopRAMController {

    @Autowired
    private LaptopRAMService laptopRAMService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopRAMService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopRAMDTO laptopRAMDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopRAMService.save(laptopRAMDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopRAMService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopRAMDTO laptopRAMDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopRAMService.update(laptopRAMDTO));
    }
}
