package io.com.cart.api.cartmanagement.exception;

import io.com.cart.api.cartmanagement.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class CartExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(
            final NotFoundException notFoundException) {

        List<String> errorList = new ArrayList<>();
        errorList.add(notFoundException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(Instant.now(),
                HttpStatus.NOT_FOUND.toString(),
                errorList);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(
            final BadRequestException badRequestException) {

        List<String> errorList = new ArrayList<>();
        errorList.add(badRequestException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(Instant.now(),
                HttpStatus.NOT_FOUND.toString(),
                errorList);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
