package com.ecommerce.computerequipmentsales.controller.normalization;

import com.ecommerce.computerequipmentsales.constants.ApiEndpoints;
import com.ecommerce.computerequipmentsales.dto.normalizationDTO.MainboardRAMDTO;
import com.ecommerce.computerequipmentsales.response.ApiResponse;
import com.ecommerce.computerequipmentsales.service.normalization.MainboardRAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndpoints.MAINBOARD_RAM_API_URL)
public class MainboardRAMController {

    @Autowired
    private MainboardRAMService mainboardRAMService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    public ApiResponse findAll(){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardRAMService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody MainboardRAMDTO mainboardRAMDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardRAMService.save(mainboardRAMDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        mainboardRAMService.delete(id);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody MainboardRAMDTO mainboardRAMDTO){
        return new ApiResponse(HttpStatus.OK, "SUCCESS", mainboardRAMService.update(mainboardRAMDTO));
    }
}
