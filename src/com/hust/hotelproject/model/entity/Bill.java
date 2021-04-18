/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.model.entity;

/**
 *
 * @author hoangminh
 */
public class Bill {
    String bookingId;
    String customerName;
    String roomName;
    String serviceName;
    String employeeName;
    String timeIn;
    String timeOut;
    Long price;
    
    public Bill() {
        
    }

    public Bill(String bookingId, String customerName, String roomName, String serviceName, String employeeName, String timeIn, String timeOut, Long price) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomName = roomName;
        this.serviceName = serviceName;
        this.employeeName = employeeName;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.price = price;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" + "bookingId=" + bookingId + ", customerName=" + customerName + ", roomName=" + roomName + ", serviceName=" + serviceName + ", employeeName=" + employeeName + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", price=" + price + '}';
    }
    
    
}
