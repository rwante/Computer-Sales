package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.SSDDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.SSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.SSD_API_URL)
public class SSDController {

    @Autowired
    private SSDService ssdService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ssdService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody SSDDTO ssddto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ssdService.save(ssddto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        ssdService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody SSDDTO ssddto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ssdService.update(ssddto));
    }
}
