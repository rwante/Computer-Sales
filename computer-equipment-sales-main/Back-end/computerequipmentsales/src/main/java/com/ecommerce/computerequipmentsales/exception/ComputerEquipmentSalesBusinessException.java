package com.ecommerce.computerequipmentsales.exception;

public class ComputerEquipmentSalesBusinessException extends RuntimeException{
    public ComputerEquipmentSalesBusinessException() {
    }

    public ComputerEquipmentSalesBusinessException(String message) {
        super(message);
    }

    public ComputerEquipmentSalesBusinessException(Throwable cause) {
        super(cause);
    }

    public ComputerEquipmentSalesBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComputerEquipmentSalesBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
