package com.bookingSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookingSystem.entity.BookedMovies;

@Repository
public interface BookedMoviesRepository extends JpaRepository<BookedMovies, Integer> {
    
}
