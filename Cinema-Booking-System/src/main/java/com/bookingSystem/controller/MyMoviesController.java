package com.bookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookingSystem.service.MyMoviesService;

@Controller
public class MyMoviesController {
	
	@Autowired
	private MyMoviesService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_movies";
	}
}
