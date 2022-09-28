package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.Turf;

public interface TurfRepo extends JpaRepository<Turf, Integer> {
	
	@Query(value = "SELECT * FROM turf_tbl t WHERE t.turf_address = :turfAdd", nativeQuery = true)
	List<Turf> findTurfsByAdd (
	  @Param("turfAdd") String turfAdd);
	
	@Query(value = "SELECT * FROM turf_tbl t WHERE t.turf_name = :turfName", nativeQuery = true)
	Turf findTurfByName (
	  @Param("turfName") String turfName);
}
