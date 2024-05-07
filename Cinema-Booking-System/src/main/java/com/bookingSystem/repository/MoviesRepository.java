package com.bookingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bookingSystem.entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    @Query("SELECT DISTINCT name FROM Movies")
    List<String> findAllNames();
}
