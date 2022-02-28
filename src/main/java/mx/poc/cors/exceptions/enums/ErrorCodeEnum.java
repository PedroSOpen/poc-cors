package mx.poc.cors.exceptions.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCodeEnum {

    INVALID_REQUEST("invalid_request", "Invalid Parameter %s %s", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("remote_service_not_available", "External service %s is not responding.", HttpStatus.INTERNAL_SERVER_ERROR),
    SUPPLIER_INVENTORY_NOT_AVAILABLE("SUPPLIER_INVENTORY_NOT_AVAILABLE", "SUPPLIER_INVENTORY_NOT_AVAILABLE.", HttpStatus.CONFLICT),
    SKU_NOT_VALID("SKU_NOT_VALID", "SKU_NOT_VALID.", HttpStatus.CONFLICT),
    THERE_IS_NOT_ENOUGH_AVAILABILITY_IN_STOCK("THERE_IS_NOT_ENOUGH_AVAILABILITY_IN_STOCK", "THERE_IS_NOT_ENOUGH_AVAILABILITY_IN_STOCK.", HttpStatus.CONFLICT),
    THERE_IS_NO_SALE_IN_PROCESS("THERE_IS_NO_SALE_IN_PROCESS", "THERE_IS_NO_SALE_IN_PROCESS.", HttpStatus.CONFLICT),
    LIST_OF_SKUS_NOT_RECEIVED("LIST_OF_SKUS_NOT_RECEIVED", "LIST_OF_SKUS_NOT_RECEIVED.", HttpStatus.CONFLICT);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    private ErrorCodeEnum(String code, String message, HttpStatus httpStatus){
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }


}
