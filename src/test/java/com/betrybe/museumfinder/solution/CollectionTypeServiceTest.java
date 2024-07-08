package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CollectionTypeServiceTest {

  @MockBean
  MuseumFakeDatabase database;

  @Autowired
  CollectionTypeService service;

  @Test
  void countByCollectionTypesOneCollection() {
    Long mockReturn = 10L;
    Mockito.when(database.countByCollectionType(any())).thenReturn(mockReturn);

    CollectionTypeCount result = service.countByCollectionTypes("hist");
    assertEquals(result.count(), mockReturn);
    assertEquals(Arrays.stream(result.collectionTypes()).toList(),
        Arrays.stream(new String[]{"hist"}).toList());

    Mockito.verify(database).countByCollectionType("hist");
  }

  @Test
  void countByCollectionTypesMoreCollections() {
    Long mockReturn = 10L;
    Mockito.when(database.countByCollectionType(any())).thenReturn(mockReturn);

    CollectionTypeCount result = service.countByCollectionTypes("hist, imag");
    assertEquals(result.count(), 20L);
    assertEquals(Arrays.stream(result.collectionTypes()).toList(),
        Arrays.stream(new String[]{"hist", "imag"}).toList());

    Mockito.verify(database).countByCollectionType("hist");
    Mockito.verify(database).countByCollectionType("imag");
  }
}
