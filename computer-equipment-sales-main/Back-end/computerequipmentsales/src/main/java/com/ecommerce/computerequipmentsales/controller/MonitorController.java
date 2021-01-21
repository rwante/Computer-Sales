package com.ecommerce.computerequipmentsales.controller;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.MonitorDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.MONITOR_API_URL)
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody MonitorDTO monitorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorService.save(monitorDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        monitorService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody MonitorDTO monitorDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorService.update(monitorDTO));
    }
}
