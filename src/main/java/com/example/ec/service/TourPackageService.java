package com.example.ec.service;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.controller.TourPackage;
import com.example.ec.repo.TourPackageRepository;


@Service
public class TourPackageService {
	private TourPackageRepository tourPackageRepository;

	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}
	
	
	// create a tour package  code and name two attributes of package
	// it will return a tourPackage
	
	public TourPackage createTourPackage(String code, String name) {
			
		return tourPackageRepository.findById(code)
		.orElse(tourPackageRepository.save(new TourPackage(code, name)));
	}
	
	
	//look up all tour package 
	public Iterable<TourPackage> lookup(){
		return tourPackageRepository.findAll();
		
	}
	
	//return list of tour package
	public long count() {
		return tourPackageRepository.count();
	}
	
}
