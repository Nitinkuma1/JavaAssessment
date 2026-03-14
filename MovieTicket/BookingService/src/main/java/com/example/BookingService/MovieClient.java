package com.example.BookingService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.BookingService.dto.Movie;

@FeignClient(name="MOVIESERVICE")
public interface MovieClient {
	@GetMapping("/movies/{id}")
    Movie getMovie(@PathVariable int id);
}