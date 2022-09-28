package com.project.services;

import java.sql.Date;
import java.util.List;

import com.project.entity.BookingDetails;
import com.project.entity.Turf;
import com.project.entity.User;

public interface BookingDetailsService {

	//create
	BookingDetails addBooking(BookingDetails bookingDetails);
	
	//Read
	BookingDetails getBooking(Integer bookingId);
	
	//Read
	List<BookingDetails> getBookingsofUser(Integer userId);
	
	//Read
	List<BookingDetails> getBookingsofTurf(Integer turfId);
	
	//Read
//	List<BookingDetails> getBookingsByDate(Date date);
	List<BookingDetails> getBookingsByDate(String date);
	
	//Read
	List<BookingDetails> getBookingsByDateandTurf(Integer turfId, String date);
	
	//Read
	List<BookingDetails> getAllBookings();
	
	//Update
	BookingDetails updateBooking(BookingDetails bookingDetails, Integer bookingId);
	
	//Delete
	void deleteBooking(Integer bookingId);
}
