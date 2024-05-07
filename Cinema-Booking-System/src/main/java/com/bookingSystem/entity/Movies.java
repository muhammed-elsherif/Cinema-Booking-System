package com.bookingSystem.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.ElementCollection;
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
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String imageUrl;
	private String name;
	private String director;
	private String writer;
	@ElementCollection
	private List<String> cast;
	private String description;
	private String genre;
	private String country;
	private Date releaseDate;
	private Double rating;
}
