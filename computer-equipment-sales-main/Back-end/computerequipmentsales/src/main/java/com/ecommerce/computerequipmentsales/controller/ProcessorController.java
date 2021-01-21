package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.ProcessorDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.PROCESSOR_API_URL)
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", processorService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody ProcessorDTO processorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", processorService.save(processorDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        processorService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody ProcessorDTO processorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", processorService.update(processorDTO));
    }
}
