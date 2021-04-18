/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.controller;

import com.hust.hotelproject.model.dao.BookingDao;
import com.hust.hotelproject.model.entity.Booking;
import java.util.List;

/**
 *
 * @author hoangminh
 */
public class BookingController {
    BookingDao bookingDao;
    public BookingController() {
        this.bookingDao = new BookingDao();
    }
    
    public List<Booking> returnAllBooking() {
        return bookingDao.getAllBooking();
    }
    
    public List<Booking> findBooking(String name) {
        return bookingDao.findBooking(name);
    }
    
    public boolean insertBooking(Booking booking) {
        return bookingDao.insertBooking(booking);
        
    }
    
    public void deleteBooking(String bookingId) {
        bookingDao.deleteBooking(bookingId);
    }
    
    
}
