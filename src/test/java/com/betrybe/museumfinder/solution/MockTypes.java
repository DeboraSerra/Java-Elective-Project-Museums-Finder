package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;

public class MockTypes {

  static CollectionTypeCount foundCollections = new CollectionTypeCount(
      new String[]{"hist", "imag"}, 10);
  static CollectionTypeCount notFoundCollections = new CollectionTypeCount(
      new String[]{"hist", "imag"},
      0);
}
