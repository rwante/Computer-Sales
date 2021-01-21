package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardGPUDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.DisplayCardGPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.DISPLAY_CARD_GPU_API_URL)
public class DisplayCardGPUController {

    @Autowired
    private DisplayCardGPUService displayCardGPUService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardGPUService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody DisplayCardGPUDTO displayCardGPUDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardGPUService.save(displayCardGPUDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        displayCardGPUService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody DisplayCardGPUDTO displayCardGPUDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardGPUService.update(displayCardGPUDTO));
    }
}
