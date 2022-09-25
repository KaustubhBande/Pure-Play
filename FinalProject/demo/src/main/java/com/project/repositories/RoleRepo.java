package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
