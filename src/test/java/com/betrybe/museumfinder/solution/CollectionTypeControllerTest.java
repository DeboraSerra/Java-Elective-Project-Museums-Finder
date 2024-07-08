package com.betrybe.museumfinder.solution;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test Collection Type Controller")
public class CollectionTypeControllerTest {


  @MockBean
  CollectionTypeService service;

  @Autowired
  MockMvc mock;

  @Test
  void testCollectionTypesCountOK() throws Exception {
    CollectionTypeCount collectionCount = MockTypes.foundCollections;
    Mockito.when(service.countByCollectionTypes(any())).thenReturn(collectionCount);

    ResultActions result = mock.perform(get("/collections/count/hist,imag"));

    result.andExpect(status().isOk())
        .andExpect(jsonPath("$.count").value(collectionCount.count()));

    Mockito.verify(service).countByCollectionTypes(any());
  }

  @Test
  void testCollectionTypesCountNotFound() throws Exception {
    CollectionTypeCount collectionCount = MockTypes.notFoundCollections;
    Mockito.when(service.countByCollectionTypes(any())).thenReturn(collectionCount);

    ResultActions result = mock.perform(get("/collections/count/hist,imag"));

    result.andExpect(status().isNotFound());
    Mockito.verify(service).countByCollectionTypes(any());
  }
}
