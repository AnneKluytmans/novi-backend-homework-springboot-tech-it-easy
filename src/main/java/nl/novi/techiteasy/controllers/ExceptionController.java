package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.exceptions.InvalidTelevisionNameException;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFound(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleIndexOutOfBounds(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidTelevisionNameException.class)
    public ResponseEntity<Object> handleInvalidTelevisionName(InvalidTelevisionNameException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}