package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.HDDDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.HDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.HDD_API_URL)
public class HDDController {

    @Autowired
    private HDDService hddService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", hddService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody HDDDTO hdddto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", hddService.save(hdddto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        hddService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody HDDDTO hdddto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", hddService.update(hdddto));
    }
}
