package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.LaptopDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.LAPTOP_API_URL)
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody LaptopDTO laptopDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopService.save(laptopDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        laptopService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody LaptopDTO laptopDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", laptopService.update(laptopDTO));
    }
}
