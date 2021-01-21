package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.LaptopScreenDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.LaptopScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_SCREEN_API_URL)
public class LaptopScreenController {

    @Autowired
    private LaptopScreenService laptopScreenService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopScreenService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopScreenDTO laptopScreenDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopScreenService.save(laptopScreenDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopScreenService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopScreenDTO laptopScreenDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopScreenService.update(laptopScreenDTO));
    }
}
