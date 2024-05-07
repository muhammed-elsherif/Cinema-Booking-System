package com.bookingSystem.repository;

import com.bookingSystem.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {

    @Query("SELECT DISTINCT capacity FROM BookingDetails")
    List<String> findAllCapacities();
    
    @Query("SELECT DISTINCT location FROM BookingDetails")
    List<String> findAllLocations();

    @Query("SELECT DISTINCT cinema FROM BookingDetails")
    List<String> findAllCinemas();

    @Query("SELECT DISTINCT date FROM BookingDetails")
    List<String> findAllDates();

    @Query("SELECT DISTINCT showTime FROM BookingDetails")
    List<String> findAllShowtimes();

    @Query("SELECT DISTINCT kindOfTicket FROM BookingDetails")
    List<String> findAllTicketTypes();
}
