package com.project.services;

import java.util.List;

import com.project.entity.Turf;

public interface TurfService {

	//Create
	Turf addTurf(Turf turf);
	
	//Read
	Turf getTurf(Integer turfId);
	
	//Read
	List<Turf> getTurfByAdd(String turfAdd);
	
	//Read
	List<Turf> getAllTurfs();
	
	//Update
	Turf updateTurf(Turf turf, Integer turfId);
	
	//Delete
	void deleteTurf(Integer turfId);
}
