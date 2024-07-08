package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  /**
   * The Service.
   */
  MuseumServiceInterface service;

  /**
   * Instantiates a new Museum controller.
   *
   * @param service the service
   */
  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /**
   * Post museum response entity.
   *
   * @param museum the museum
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<MuseumDto> postMuseum(@RequestBody MuseumCreationDto museum) {
    System.out.println(museum);
    Museum result = service.createMuseum(ModelDtoConverter.dtoToModel(museum));
    MuseumDto response = ModelDtoConverter.modelToDto(result);
    System.out.println(response);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  /**
   * Gets closest museum.
   *
   * @param lat      the lat
   * @param lng      the lng
   * @param distance the distance
   * @return the closest museum
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(@RequestParam String lat,
      @RequestParam String lng, @RequestParam(name = "max_dist_km") String distance) {
    Coordinate coordinate = new Coordinate(Double.parseDouble(lat), Double.parseDouble(lng));
    Museum museum = service.getClosestMuseum(coordinate, Double.parseDouble(distance));
    MuseumDto response = ModelDtoConverter.modelToDto(museum);
    return ResponseEntity.ok(response);
  }

}
