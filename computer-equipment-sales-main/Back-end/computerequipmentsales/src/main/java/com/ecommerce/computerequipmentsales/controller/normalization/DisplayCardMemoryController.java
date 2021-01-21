package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.DisplayCardMemoryDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.DisplayCardMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.DISPLAY_CARD_MEMORY_API_URL)
public class DisplayCardMemoryController {

    @Autowired
    private DisplayCardMemoryService displayCardMemoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardMemoryService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody DisplayCardMemoryDTO displayCardMemoryDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardMemoryService.save(displayCardMemoryDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        displayCardMemoryService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody DisplayCardMemoryDTO displayCardMemoryDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", displayCardMemoryService.update(displayCardMemoryDTO));
    }
}
