package com.project.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="booking_dtls")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookingDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date bookingDate;
	private String bookingTime;
	private Date slotbookingDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="turf_id")
	private Turf turf;

	public BookingDetails(Integer id, Date bookingDate, String bookingTime, Date slotbookingDate, User user,
			Turf turf) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.slotbookingDate = slotbookingDate;
		this.user = user;
		this.turf = turf;
	}

	
}
