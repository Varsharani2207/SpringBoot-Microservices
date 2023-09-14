package com.example.ec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ec.controller.Difficulty;
import com.example.ec.controller.Region;
import com.example.ec.controller.TourPackage;
import com.example.ec.service.TourPackageService;
import com.example.ec.service.TourService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	//@Value("${importfile}")
	//private String importFile;

	@Autowired
	private TourPackageService tourPackageService;
	
	@Autowired
	private TourService tourService;
	
	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		createTourPackages();
		long numOfPackages=tourPackageService.count();
		
		//load the tours from external json file
		
		createTours();
		long numOfTours= tourService.total();
		
	}

	private void createTourPackages() {
		
		// create tourpackages
		tourPackageService.createTourPackage("BC", "BackPack");
		tourPackageService.createTourPackage("CC", "California Calling");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("TC", "Taste of California");
	}
	
	
	private void createTours() {
		//add tour here on load
		tourService.createTour("Backpack Cal", "BigSur Retreat", "Big Sur is Big Country", 750, "3 Days", "Central Coast" ,
				"Hiking, National Parks, Big Sur","BackPack", Difficulty.valueOf("Medium")  , Region.valueOf("Central_Coast"));
		
		tourService.createTour("Backpack Cal", "BigSur Retreat", "Big Sur is Big Country", 750, "3 Days", "Central Coast" ,
				"Hiking, National Parks, Big Sur","BackPack", Difficulty.valueOf("Medium")  , Region.valueOf("Central_Coast"));

	}
	
	/*
	 * private void createTours(String fileToImport) throws IOException{
	 * TourFromFile.read(fileToImport).forEach(importedTour ->
	 * 
	 * tourService.createTour(importedTour.getTitle(),
	 * importedTour.getDescription(), importedTour.getBlurb(),
	 * importedTour.getPrice(), importedTour.getDuration(),
	 * importedTour.getBullets(), importedTour.getKeywords(),
	 * importedTour.getPackageType(), importedTour.getDifficulty(),
	 * importedTour.getRegion()));
	 * 
	 * }
	 * 
	 * //helper class to import json file
	 * 
	 * private static class TourFromFile{ private String packageType,
	 * title,description,blurb, price, duration, bullets, keywords, tourPackage,
	 * difficulty, region;
	 * 
	 * static List<TourFromFile> read(String fileToImport) throws IOException {
	 * return new ObjectMapper().setVisibility(FIELD, ANY). readValue(new
	 * FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {}); }
	 * protected TourFromFile() {}
	 * 
	 * String getPackageType() {return packageType;}
	 * 
	 * String getTitle() {return title;}
	 * 
	 * String getDescription() { return description; }
	 * 
	 * String getBlurb() { return blurb; }
	 * 
	 * Integer getPrice() { return Integer.parseInt(price); }
	 * 
	 * String getDuration() { return duration; }
	 * 
	 * String getBullets() { return bullets; }
	 * 
	 * String getKeywords() { return keywords; }
	 * 
	 * Difficulty getDifficulty() { return Difficulty.valueOf(difficulty); }
	 * 
	 * Region getRegion() { return Region.findByLabel(region); }
	 * 
	 * }
	 */}

