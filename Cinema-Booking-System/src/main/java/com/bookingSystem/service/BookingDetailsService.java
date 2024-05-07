package com.bookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookingSystem.entity.BookingDetails;
import com.bookingSystem.repository.BookingDetailsRepository;

@Service

public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingRepo;

    public void save(BookingDetails b) {
        bookingRepo.save(b);
    }

    public List<BookingDetails> getAllBookingDetails() {
        return bookingRepo.findAll();
    }

    public List<String> getAllLocations() {
        return bookingRepo.findAllLocations();
    }

    public List<String> getAllCapacities() {
        return bookingRepo.findAllCapacities();
    }
    
    public List<String> getAllCinemas() {
        return bookingRepo.findAllCinemas();
    }

    public List<String> getAllDates() {
        return bookingRepo.findAllDates();
    }

    public List<String> getAllShowtimes() {
        return bookingRepo.findAllShowtimes();
    }

    public List<String> getAllTicketTypes() {
        return bookingRepo.findAllTicketTypes();
    }

    public void deleteById(int id) {
        bookingRepo.deleteById(id);
    }
}
