package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.RAMDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.RAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.RAM_API_URL)
public class RAMController {

    @Autowired
    private RAMService ramService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ramService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody RAMDTO ramdto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ramService.save(ramdto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        ramService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody RAMDTO ramdto){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", ramService.update(ramdto));
    }
}
