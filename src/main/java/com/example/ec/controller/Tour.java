package com.example.ec.controller;

import javax.persistence.*;

@Entity
public class Tour {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private String blurb;
	
	@Column
	private Integer price;
	
	@Column
	private String duration;
	
	@Column(length = 2000)
	private String bullets;
	
	@Column
	private String keywords;
	
	@ManyToOne
	private TourPackage tourPackage;
	
	
	@Column
	@Enumerated
	private Difficulty difficulty;
	
	@Column
	@Enumerated
	private Region region;

	public Tour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
		super();
		//this.id = id;
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;	
		this.bullets = bullets;
		this.keywords = keywords;
		this.tourPackage = tourPackage;
		this.difficulty = difficulty;
		this.region = region;
	}
	
	
	
}
