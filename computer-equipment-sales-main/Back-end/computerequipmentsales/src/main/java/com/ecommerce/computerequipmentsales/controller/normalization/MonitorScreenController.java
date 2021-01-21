package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MonitorScreenDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.MonitorScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.MONITOR_SCREEN_API_URL)
public class MonitorScreenController {

    @Autowired
    private MonitorScreenService monitorScreenService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorScreenService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody MonitorScreenDTO monitorScreenDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorScreenService.save(monitorScreenDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        monitorScreenService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody MonitorScreenDTO monitorScreenDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", monitorScreenService.update(monitorScreenDTO));
    }
}
