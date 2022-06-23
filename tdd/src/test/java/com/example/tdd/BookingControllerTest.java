package com.example.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import com.example.tdd.controller.BookingController;
import com.example.tdd.model.BookingModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void bookingTestGetAll() throws Exception {
    
    mockMvc.perform(get("/bookings"))
      .andExpect(status().isOk());
  }
  
  @Test
  public void bookingTestSave() throws JsonProcessingException, Exception {
    LocalDate checkIn = LocalDate.parse("2022-06-10");
		LocalDate checkOut = LocalDate.parse("2022-06-20");
    
		BookingModel bookingModel = new BookingModel("1", "Maria", checkIn, checkOut, 2);
    
    mockMvc.perform(post("/bookings")
      .contentType("application/json")
      .content(objectMapper.writeValueAsString(bookingModel)))
      .andExpect(status().isOk());
  }

  @Test
  public void bookingTestPut() throws JsonProcessingException, Exception {
    LocalDate checkIn = LocalDate.parse("2022-06-10");
		LocalDate checkOut = LocalDate.parse("2022-06-20");
    
		BookingModel bookingModel = new BookingModel("1", "Maria", checkIn, checkOut, 2);
    
    mockMvc.perform(put("/bookings")
      .contentType("application/json")
      .content(objectMapper.writeValueAsString(bookingModel)))
      .andExpect(status().isOk());
  }

  @Test
  public void bookingTestDelete() throws JsonProcessingException, Exception {
    LocalDate checkIn = LocalDate.parse("2022-06-10");
		LocalDate checkOut = LocalDate.parse("2022-06-20");
    
		BookingModel bookingModel = new BookingModel("1", "Maria", checkIn, checkOut, 2);
    
    mockMvc.perform(delete("/bookings")
      .contentType("application/json")
      .content(objectMapper.writeValueAsString(bookingModel)))
      .andExpect(status().isOk());
  }
}
