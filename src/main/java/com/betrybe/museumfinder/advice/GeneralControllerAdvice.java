package com.betrybe.museumfinder.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;

@ControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(InvalidCoordinateException.class)
    public ResponseEntity<String> handleCoordinate() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
    }

    @ExceptionHandler(MuseumNotFoundException.class)
    public ResponseEntity<String> handleNotFoundMuseum() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleGeneric() {
        return ResponseEntity.status(500).body("Erro interno!");
    }
}
