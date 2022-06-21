package com.example.tdd;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repositories.BookingRepository;
import com.example.tdd.service.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {
	
	@TestConfiguration
	static class BookingServiceTestConfiguration {
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository repository;
	
	@Test
	public void bookingTestServiceDaysCalculator() {
		
		String name = "Maria";
		int days = bookingService.daysCalculatorWithDatabase(name);
		
		Assertions.assertEquals(days, 10);
	}
	
	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2022-06-10");
		LocalDate checkOut = LocalDate.parse("2022-06-20");
		BookingModel bookingModel = new BookingModel("1", "Maria", checkIn, checkOut, 2);
		
		Mockito.when(repository.findByReserveName(bookingModel.getReserveName()))
			.thenReturn(java.util.Optional.of(bookingModel));
	}
}
