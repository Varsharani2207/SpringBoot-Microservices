package com.example.ec.controller;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TourPackage {
	
	@Id
	private String code;
	
	@Column
	private String name;

	public TourPackage() {}
	public TourPackage(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
}
