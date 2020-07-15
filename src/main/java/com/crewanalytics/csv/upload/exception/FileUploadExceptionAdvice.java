package com.crewanalytics.csv.upload.exception;

import com.crewanalytics.csv.upload.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException e) {

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File is too large!!"));

    }

}
