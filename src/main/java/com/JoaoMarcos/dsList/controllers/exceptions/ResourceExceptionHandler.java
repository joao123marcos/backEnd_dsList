package com.JoaoMarcos.dsList.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.JoaoMarcos.dsList.services.exceptions.IndexOfBoundsException;
import com.JoaoMarcos.dsList.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity <StandardError> resourceNotFound 
    (ResourceNotFoundException e, HttpServletRequest request){

      String defaultError = "Resource not found ";
      HttpStatus status = HttpStatus.NOT_FOUND;
      StandardError erro = new StandardError(Instant.now(), 
      status.value(), defaultError, e.getMessage(), request.getRequestURI());
       
      return ResponseEntity.status(status).body(erro);
   }

   @ExceptionHandler(IndexOfBoundsException.class)
   public ResponseEntity <StandardError> indexOfBoundsException
     (IndexOfBoundsException e, HttpServletRequest request){
     
      String defaultError = "Index Out Of Bounds!";
      HttpStatus status = HttpStatus.BAD_REQUEST;
      StandardError erro = new StandardError(Instant.now(), 
      status.value(), defaultError, e.getMessage(), request.getRequestURI());
       
      return ResponseEntity.status(status).body(erro);

   }


}
