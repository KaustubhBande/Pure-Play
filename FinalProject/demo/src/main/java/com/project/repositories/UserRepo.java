package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM User_tbl u WHERE u.email = :email", nativeQuery = true)
	User fetchUserByEmail(
	@Param("email") String email);
}
