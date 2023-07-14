package com.example.worldservice.execptions;

import com.example.worldservice.dto.ErrorMessageDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({NoSuchElementException.class, NoDataFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageDTO handleNoDataException(HttpServletRequest request,Exception ex)
    {
        return ErrorMessageDTO.builder().message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.toString())
                .path(request.getRequestURI()).build();
    }
}
