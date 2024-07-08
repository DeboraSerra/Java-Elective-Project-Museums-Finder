package com.betrybe.museumfinder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;

@Service
public class MuseumService implements MuseumServiceInterface {

    MuseumFakeDatabase db;

    @Autowired
    public void MuseumService(MuseumFakeDatabase database) {
        db = database;
    }

    @Override
    public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
        boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
        if (!isCoordinateValid) {
            throw new InvalidCoordinateException();
        }
        Optional<Museum> museum = db.getClosestMuseum(coordinate, maxDistance);
        if (museum.isEmpty()) {
          throw new MuseumNotFoundException();
        }
        return museum.get();
    }

    @Override
    public Museum createMuseum(Museum museum) {
        boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());
        if (!isCoordinateValid) {
            throw new InvalidCoordinateException();
        }

        return db.saveMuseum(museum);
    }

    @Override
    public Museum getMuseum(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMuseum'");
    }

}
