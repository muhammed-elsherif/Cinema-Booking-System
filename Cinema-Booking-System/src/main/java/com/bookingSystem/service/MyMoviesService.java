package com.bookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingSystem.entity.MyMovies;
import com.bookingSystem.repository.MyMoviesRepository;

@Service
public class MyMoviesService {
	
	@Autowired
	private MyMoviesRepository mymovie;
	
	public void saveMymovies(MyMovies movie) {
		mymovie.save(movie);
	}
	
	public List<MyMovies> getAllMymovies(){
		return mymovie.findAll();
	}
	
	public void deleteById(int id) {
		mymovie.deleteById(id);
	}
}
