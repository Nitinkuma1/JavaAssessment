package com.example.BookingService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingService.MovieClient;
import com.example.BookingService.Model.Booking;
import com.example.BookingService.dto.Movie;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private MovieClient movieClient;

    List<Booking> bookings = new ArrayList<>();

    @PostMapping
    public Booking bookMovie(@RequestBody Booking booking) {

    	Movie movie = movieClient.getMovie(booking.getMovieId());

        double total = movie.getPrice() * booking.getTickets() * booking.getTotalAmount();
        booking.setTotalAmount(total);

        bookings.add(booking);

        return booking;
    }

    @GetMapping
    public List<Booking> getBookings() {
        return bookings;
    }
}
