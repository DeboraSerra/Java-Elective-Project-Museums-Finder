package com.betrybe.museumfinder.solution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
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
public class MuseumControllerTest {

  @MockBean
  MuseumService service;

  @Autowired
  MockMvc mock;

  @Test
  public void mustFindMuseumOk() throws Exception {
    Museum mockMuseum = MockMuseum.createMuseum();
    Mockito.when(service.getMuseum(1L)).thenReturn(mockMuseum);
    ResultActions result = mock.perform(get("/museums/1"));
    result.andExpect(status().isOk()).andExpect(jsonPath("$.name").value(mockMuseum.getName()))
        .andExpect(jsonPath(
            "$.id").value(mockMuseum.getId()));

    Mockito.verify(service).getMuseum(1L);
  }

  @Test
  public void mustReturnNotFoundIfMuseumIsNotFound() throws Exception {
    Mockito.when(service.getMuseum(1L)).thenThrow(MuseumNotFoundException.class);
    ResultActions result = mock.perform(get("/museums/1"));
    result.andExpect(status().isNotFound());
    Mockito.verify(service).getMuseum(1L);
  }
}
