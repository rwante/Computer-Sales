package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopProcessorDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_PROCESSOR_API_URL)
public class LaptopProcessorController {

    @Autowired
    private LaptopProcessorService laptopProcessorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopProcessorService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopProcessorDTO laptopProcessorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopProcessorService.save(laptopProcessorDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopProcessorService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopProcessorDTO laptopProcessorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopProcessorService.update(laptopProcessorDTO));
    }
}
