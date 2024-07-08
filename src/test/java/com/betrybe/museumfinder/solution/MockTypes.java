package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;

public class MockTypes {

  static CollectionTypeCount foundCollections = new CollectionTypeCount(
      new String[]{"hist", "imag"}, 10);
  static CollectionTypeCount notFoundCollections = new CollectionTypeCount(
      new String[]{"hist", "imag"},
      0);
  static CollectionTypeCount notFountOneCollection = new CollectionTypeCount(new String[]{"hist"},
      0);
  static CollectionTypeCount foundOneCollection = new CollectionTypeCount(new String[]{"hist"}, 5);

  static String[] collectionTypesMoreItems = new String[]{"hist", "imag"};
  static String[] collectionTypesOneItem = new String[]{"hist"};
}
