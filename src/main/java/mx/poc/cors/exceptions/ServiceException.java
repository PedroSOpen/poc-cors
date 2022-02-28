package mx.poc.cors.exceptions;

import lombok.Getter;
import mx.poc.cors.exceptions.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends BaseException{
    protected final HttpStatus httpStatus;

    protected final String code;

    protected final String message;

    public ServiceException(final ErrorCodeEnum error, String... params){
        super();
        this.httpStatus = error.getHttpStatus();
        this.code = error.getCode();
        this.message = String.format(error.getMessage(), (Object[]) params);
    }
}
