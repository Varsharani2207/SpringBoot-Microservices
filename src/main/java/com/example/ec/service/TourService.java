package com.example.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.controller.Difficulty;
import com.example.ec.controller.Region;
import com.example.ec.controller.Tour;
import com.example.ec.controller.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import com.example.ec.repo.TourRepository;

@Service
public class TourService {

	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository= tourPackageRepository;
	}
	
	//create a new Tour object and persist it into database
	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
		
		//checking if package exists, if not then create new one
		
		TourPackage tourPackage=tourPackageRepository.findByName(tourPackageName)
				.orElseThrow(()-> new RuntimeException("Package not Found"+ tourPackageName));
		
	return new Tour(title,description,blurb,price,duration,bullets,keywords, tourPackage, difficulty, region);
	}
	
	//get the total number of tour
	public long total() { return tourRepository.count();}
}
