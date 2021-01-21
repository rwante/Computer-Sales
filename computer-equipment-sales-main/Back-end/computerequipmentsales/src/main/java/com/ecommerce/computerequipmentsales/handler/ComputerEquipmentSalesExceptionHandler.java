package com.ecommerce.computerequipmentsales.handler;

import com.ecommerce.computerequipmentsales.exception.ComputerEquipmentSalesBusinessException;
import com.ecommerce.computerequipmentsales.response.ComputerEquipmentSalesExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
@RestController
public class ComputerEquipmentSalesExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ComputerEquipmentSalesBusinessException.class)
    public final ResponseEntity<ComputerEquipmentSalesExceptionResponse> SmartFarmExceptionResponse(ComputerEquipmentSalesBusinessException ex, WebRequest request) {
        ComputerEquipmentSalesExceptionResponse exceptionResponse = new ComputerEquipmentSalesExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
