package com.project.services;

import com.project.entity.Role;

public interface RoleService {

	//Read
	Role fetchRoleByName(String name);
}
