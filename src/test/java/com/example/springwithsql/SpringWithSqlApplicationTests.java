package com.example.springwithsql;

import com.example.springwithsql.Controller.HorseController;
import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Repository.HorseRepository;
import com.example.springwithsql.Database.Repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HorseController.class) // Upewnij się, że nazwa kontrolera jest poprawna
class HorseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HorseRepository horseRepository;

    @MockBean
    private LogRepository logRepository;

    @Test
    void testGetHorseById_Success() throws Exception {
        // Mockowane dane
        Horse horse = new Horse("Thunder", "Arabian", "Bay", "Flash", "Luna", "Champion horse", LocalDate.of(2015, 5, 20));
        horse.setId(1999L); // Ustaw ID, aby pasowało do struktury encji

        Mockito.when(horseRepository.findById(1999L)).thenReturn(Optional.of(horse));

        // Wykonanie żądania i weryfikacja odpowiedzi
        mockMvc.perform(get("/api/Horse/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1999))
                .andExpect(jsonPath("$.name").value("Thunder"))
                .andExpect(jsonPath("$.race").value("Arabian"))
                .andExpect(jsonPath("$.ointment").value("Bay"));

        // Weryfikacja, czy zapisano log
        verify(logRepository).save(any());
    }

    @Test
    void testGetHorseById_NotFound() throws Exception {
        // Gdy ID nie istnieje
        Mockito.when(horseRepository.findById(2423L)).thenReturn(Optional.empty());

        // Wykonanie żądania i weryfikacja odpowiedzi
        mockMvc.perform(get("/api/Horse/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(""));

        // Weryfikacja, czy zapisano log
        verify(logRepository).save(any());
    }
}
