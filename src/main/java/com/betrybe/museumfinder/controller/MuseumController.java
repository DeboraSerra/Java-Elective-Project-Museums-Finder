package com.betrybe.museumfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;

@RestController
@RequestMapping("/museums")
public class MuseumController {

    MuseumServiceInterface service;

    @Autowired
    public void MuseumController(MuseumServiceInterface service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<MuseumDto> postMuseum(@RequestBody MuseumCreationDto museum) {
        Museum result = service.createMuseum(ModelDtoConverter.dtoToModel(museum));
        MuseumDto response = ModelDtoConverter.modelToDto(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
