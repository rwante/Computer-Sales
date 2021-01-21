package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopGPUDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopGPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_GPU_API_URL)
public class LaptopGPUController {

    @Autowired
    private LaptopGPUService laptopGPUService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopGPUService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopGPUDTO laptopGPUDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopGPUService.save(laptopGPUDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopGPUService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopGPUDTO laptopGPUDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopGPUService.update(laptopGPUDTO));
    }
}
