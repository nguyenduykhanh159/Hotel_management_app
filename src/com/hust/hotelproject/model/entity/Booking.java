/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.model.entity;

import java.sql.Date;

/**
 *
 * @author hoangminh
 */
public class Booking {
    String bookId;
    String customerId;
    String customerName;
    String roomID;
    String serviceId;
    String employeeId;
    Date timeCheckIn;
    Date timeCheckOut;
    
    
    public Booking() {
        
    }

    public Booking(String bookId, String customerId, String customerName, String roomID, String serviceId, String employeeId, Date timeCheckIn, Date timeCheckOut) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.roomID = roomID;
        this.serviceId = serviceId;
        this.employeeId = employeeId;
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
    }
    
    public Booking(String bookId, String customerId, String customerName, String roomID, String serviceId, String employeeId, Date timeCheckOut) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.roomID = roomID;
        this.serviceId = serviceId;
        this.employeeId = employeeId;
        this.timeCheckOut = timeCheckOut;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Date getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setTimeCheckOut(Date timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }

    public Date getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(Date timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }
    
    @Override
    public String toString() {
        return "Booking{" + "bookId=" + bookId + ", customerId=" + customerId + ", customerName=" + customerName + ", roomID=" + roomID + ", serviceId=" + serviceId + ", employeeId=" + employeeId + ", timeCheckOut=" + timeCheckOut + '}';
    }
    
}
