package com.example.ec.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ec.controller.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {

}
