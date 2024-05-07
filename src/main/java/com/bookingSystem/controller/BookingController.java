package com.bookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookingSystem.entity.BookedMovies;
import com.bookingSystem.entity.BookingDetails;
import com.bookingSystem.service.BookedMoviesService;
import com.bookingSystem.service.BookingDetailsService;
import com.bookingSystem.service.MoviesService;

import java.util.*;

@Controller
public class BookingController {

	@Autowired
	private BookingDetailsService bookingDetailsService;

	@Autowired
	private MoviesService namesService;

	@Autowired
	private BookedMoviesService bookedMoviesService;

	@GetMapping("/book")
	public String showBookingForm(Model model) {

		List<String> titles = namesService.getAllNames();
		List<String> cinemas = bookingDetailsService.getAllCinemas();
		List<String> capacities = bookingDetailsService.getAllCapacities();
		List<String> locations = bookingDetailsService.getAllLocations();
		List<String> dates = bookingDetailsService.getAllDates();
		List<String> showtimes = bookingDetailsService.getAllShowtimes();
		List<String> ticketTypes = bookingDetailsService.getAllTicketTypes();

		model.addAttribute("titles", titles);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("capacities", capacities);
		model.addAttribute("locations", locations);
		model.addAttribute("dates", dates);
		model.addAttribute("showtimes", showtimes);
		model.addAttribute("ticketTypes", ticketTypes);

		return "bookingDetails";
	}

	@PostMapping("/book")
	public String saveBookedMovies(@ModelAttribute BookedMovies bookedMovies, Model model) {
		bookedMoviesService.save(bookedMovies);
		model.addAttribute("message", "Booked Successfully!");
		return "bookingDetails";

	}

	// @GetMapping("/cancel/{id}")
	// public String cancelBooking(@PathVariable("id") int id) {
	// bookedMoviesService.deleteById(id);
	// return "redirect:/available_movies";
	// }

	@GetMapping("/booked_movies")
	public String getMymovies(Model model) {
		List<BookedMovies> bookedList = bookedMoviesService.getAllBookingDetails();
		model.addAttribute("bookedmovieslist", bookedList);
		return "bookedMovies";
	}

	@GetMapping("/booking_info")
	public String bookinginfo() {
		return "enterInfo";
	}

	@PostMapping("/saveInfo")
	public String addinfo(@ModelAttribute BookingDetails b) {
		bookingDetailsService.save(b);
		return "redirect:/bookingInfo";
	}

	@GetMapping("/bookingInfo")
	public String getMyinfo(Model model) {
		List<BookingDetails> bookingDetailslist = bookingDetailsService.getAllBookingDetails();
		model.addAttribute("bookingDetailslist", bookingDetailslist);
		return "bookingInfo";
	}

	@RequestMapping("/deletedetail/{id}")
	public String deletemovie(@PathVariable("id") int id) {
		bookingDetailsService.deleteById(id);
		return "redirect:/bookingInfo";
	}
}
