package com.bookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingSystem.entity.Movies;
import com.bookingSystem.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository bRepo;

	public void save(Movies b) {
		bRepo.save(b);
	}

	public List<String> getAllNames() {
		return bRepo.findAllNames();
	}

	public List<Movies> getAllmovie() {
		return bRepo.findAll();
	}

	public Movies getmovieById(int id) {
		return bRepo.findById(id).get();
	}

	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

}
