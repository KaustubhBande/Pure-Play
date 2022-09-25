package com.project.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Role;
import com.project.repositories.RoleRepo;
import com.project.services.RoleService;


@Service
public class RoleServicesImpl implements RoleService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private RoleRepo roleRepo;
	
	//Read
	public Role fetchRoleByName(String name) {
		Query query = entityManager.createQuery("select r from Role r where r.roleName = : name");
		query.setParameter("name", name);
		Role role = (Role)query.getSingleResult();
		return role;
	}
	
}
