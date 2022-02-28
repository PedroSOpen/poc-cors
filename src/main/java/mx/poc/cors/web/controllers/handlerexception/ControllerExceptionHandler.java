package mx.poc.cors.web.controllers.handlerexception;

import lombok.extern.slf4j.Slf4j;
import mx.poc.cors.exceptions.ServiceException;
import mx.poc.cors.web.controllers.filters.FilterRequest;
import mx.poc.cors.web.controllers.filters.model.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Validated
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletResponse request)
    {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setRequestId(request.getHeader(FilterRequest.REQUEST_ID));
        final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(error -> messages.add(error.getField() + ": The field " + error.getField() + " " + error.getDefaultMessage()));
        response.setCode(String.valueOf(statusCode.value()));
        response.setMessages(messages);
        return new ResponseEntity<>(response, statusCode);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {

        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setRequestId(request.getHeader(FilterRequest.REQUEST_ID));
        final HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
        }
        response.setCode(String.valueOf(statusCode.value()));
        response.setMessages(errors);

        return new ResponseEntity<>(response, statusCode);
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseDTO> methodArgumentNotValidException(ServiceException ex, HttpServletResponse request)
    {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setRequestId(request.getHeader(FilterRequest.REQUEST_ID));
        List<String> messages = new ArrayList<>();
        messages.add(ex.getMessage());
        response.setCode(ex.getCode());
        response.setMessages(messages);
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setRequestId(request.getHeader(FilterRequest.REQUEST_ID));
        List<String> messages = new ArrayList<>();
        messages.add("The parameters for the request are incomplete.");
        response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setMessages(messages);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
