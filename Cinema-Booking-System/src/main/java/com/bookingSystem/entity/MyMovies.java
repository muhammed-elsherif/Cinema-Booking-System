package com.bookingSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MyMovies")
public class MyMovies {

	@Id
	private int id;
	private String imageUrl;
	private String name;
	private String director;
	private String writer;

}
