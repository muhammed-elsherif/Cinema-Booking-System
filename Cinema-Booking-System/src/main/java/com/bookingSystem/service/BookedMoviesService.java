package com.bookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingSystem.entity.BookedMovies;
import com.bookingSystem.repository.BookedMoviesRepository;

@Service

public class BookedMoviesService {

  @Autowired
  private BookedMoviesRepository bookedRepo;

  public void save(BookedMovies b) {
    bookedRepo.save(b);
  }

  public List<BookedMovies> getAllBookingDetails() {
    return bookedRepo.findAll();
  }
}
