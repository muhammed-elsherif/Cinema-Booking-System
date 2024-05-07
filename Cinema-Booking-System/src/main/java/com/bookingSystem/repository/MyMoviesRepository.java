package com.bookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingSystem.entity.MyMovies;

@Repository
public interface MyMoviesRepository extends JpaRepository<MyMovies,Integer>{

}
