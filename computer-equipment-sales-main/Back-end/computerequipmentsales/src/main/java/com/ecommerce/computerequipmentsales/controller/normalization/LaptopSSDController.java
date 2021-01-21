package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopSSDDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopSSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_SSD_API_URL)
public class LaptopSSDController {

    @Autowired
    private LaptopSSDService laptopSSDService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopSSDService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopSSDDTO laptopSSDDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopSSDService.save(laptopSSDDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopSSDService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopSSDDTO laptopSSDDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopSSDService.update(laptopSSDDTO));
    }
}
