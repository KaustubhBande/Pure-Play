package com.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user_tbl")
@NoArgsConstructor
public @Data class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String password;
	private String email;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="add_1")
	private String address1;
	
	@Column(name="add_2")
	private String address2;
	
	private String city;
	private String state;
	private Integer pincode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role userRole;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<BookingDetails> userBookingList;


	public User(Integer id, String name, String password, String email, String contactNo, String address1, String address2,
			String city, String state, Integer pincode) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
}
