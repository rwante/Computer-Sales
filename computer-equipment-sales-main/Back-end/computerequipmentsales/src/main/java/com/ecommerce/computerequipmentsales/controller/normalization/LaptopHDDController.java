package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopHDDDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopHDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_HDD_API_URL)
public class LaptopHDDController {

    @Autowired
    private LaptopHDDService laptopHDDService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopHDDService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopHDDDTO laptopHDDDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopHDDService.save(laptopHDDDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopHDDService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopHDDDTO laptopHDDDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopHDDService.update(laptopHDDDTO));
    }
}
