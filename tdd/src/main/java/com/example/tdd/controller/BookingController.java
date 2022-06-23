package com.example.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.model.BookingModel;

@RestController
@RequestMapping("/bookings")
public class BookingController {
  
  @GetMapping
  public String getAll() {
    return "OK";
  }
  
  @PostMapping
  @ResponseBody
  public ResponseEntity<BookingModel> save(@RequestBody BookingModel bookingModel) {
    return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
  }

  @PutMapping
  @ResponseBody
  public ResponseEntity<BookingModel> put(@RequestBody BookingModel bookingModel) {
    return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
  }

  @DeleteMapping
  @ResponseBody
  public String delete(@RequestBody BookingModel bookingModel) {
    return "OK";
  }
}
