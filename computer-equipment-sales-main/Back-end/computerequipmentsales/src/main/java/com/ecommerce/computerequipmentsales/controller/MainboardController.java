package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.MainboardDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.MainboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.MAINBOARD_API_URL)
public class MainboardController {

    @Autowired
    private MainboardService mainboardService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody MainboardDTO mainboardDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardService.save(mainboardDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        mainboardService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody MainboardDTO mainboardDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardService.update(mainboardDTO));
    }
}
