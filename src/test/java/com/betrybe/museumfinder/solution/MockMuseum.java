package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;

public class MockMuseum {

  static Museum createMuseum() {
    Museum museum = new Museum();
    museum.setId(1L);
    museum.setName("Metropolitan Museum");
    museum.setCoordinate(new Coordinate(14.324, -23.45));

    return museum;
  }
}
