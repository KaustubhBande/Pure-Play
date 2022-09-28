package com.project.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.BookingDetails;
import com.project.exceptions.ResourceNotFoundException;
import com.project.repositories.BookingDetailsRepo;
import com.project.services.BookingDetailsService;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsRepo bookingDetailsRepo;
	
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {
		BookingDetails bd = this.bookingDetailsRepo.save(bookingDetails);
		return bd;
	}

	@Override
	public BookingDetails getBooking(Integer bookingId) {
		BookingDetails bd = this.bookingDetailsRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking Details", "Id ", bookingId));
		return bd;
	}

	@Override
	public List<BookingDetails> getAllBookings() {
		List<BookingDetails> bookingList = this.bookingDetailsRepo.findAll();
		return bookingList;
	}

	@Override
	public BookingDetails updateBooking(BookingDetails bookingDetails, Integer bookingId) {
		BookingDetails oldbd = this.bookingDetailsRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking Details", "Id ", bookingId));
		
		oldbd.setBookingDate(bookingDetails.getBookingDate());
		oldbd.setBookingTime(bookingDetails.getBookingTime());
		oldbd.setSlotbookingDate(bookingDetails.getSlotbookingDate());
		oldbd.setUser(bookingDetails.getUser());
		oldbd.setTurf(bookingDetails.getTurf());
		BookingDetails newbd = this.bookingDetailsRepo.save(oldbd);
		return newbd;
	}

	@Override
	public void deleteBooking(Integer bookingId) {
		BookingDetails bd = bookingDetailsRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking Details", "Id ", bookingId));
		this.bookingDetailsRepo.delete(bd);
	}

	@Override
	public List<BookingDetails> getBookingsofUser(Integer userId) {
		List<BookingDetails> bookingList = this.bookingDetailsRepo.findbookingsOfUser(userId);
		return bookingList;
	}

	@Override
	public List<BookingDetails> getBookingsofTurf(Integer turfId) {
		List<BookingDetails> bookingList = this.bookingDetailsRepo.findbookingsOfTurf(turfId);
		return bookingList;
	}

	@Override
	public List<BookingDetails> getBookingsByDate(String bookingDate) {
		List<BookingDetails> bookingList = this.bookingDetailsRepo.findbookingsByDate(bookingDate);
		return bookingList;
	}

	@Override
	public List<BookingDetails> getBookingsByDateandTurf(Integer turfId, String date) {
		List<BookingDetails> bookingList = bookingDetailsRepo.findbookingsByDateandTurf(turfId, date);
		return bookingList;
	}

}
