package com.bookingSystem.entity;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BookingDetails {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String capacity;
	private String location;
	private String cinema;
	private Date date;
	private String showTime;
	private String kindOfTicket;
}
