package com.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="role_tbl")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Role {
	
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy="userRole")
	private List<User> users;

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
}
