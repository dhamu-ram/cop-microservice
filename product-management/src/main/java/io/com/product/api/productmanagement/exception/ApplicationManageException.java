package io.com.product.api.productmanagement.exception;

import io.com.product.api.productmanagement.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationManageException extends Exception{

    private static final long serialVersißonUID = 8371648338883940608L;

    /**
     * {@summary getProjectNotFound method is for throw the exception response when
     * project not found. }
     * @param exception if project not found
     * @param request   Return the request header of the given name
     * @return error exception for project not found
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> getProjectNotFound(final ProductNotFoundException exception,
            final WebRequest request) {
    	
        List <String> errorMessages = new ArrayList<String>();
        errorMessages.add(exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessages);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
