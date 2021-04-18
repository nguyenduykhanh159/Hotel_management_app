/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.model.dao;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Booking;
import com.hust.hotelproject.util.CloseDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangminh
 */
public class BookingDao {

    public List<Booking> getAllBooking() {
        List<Booking> listBooking = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select * from book";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Booking booking = new Booking(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getDate(7), result.getDate(8));
                    listBooking.add(booking);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return listBooking;
    }

    public List<Booking> findBooking(String name) {
        List<Booking> listBooking = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM book WHERE name LIKE '%" + name + "%'";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Booking booking = new Booking(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getDate(7));
                    listBooking.add(booking);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listBooking;
    }

    public boolean insertBooking(Booking booking) {
        PreparedStatement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            final String sql = "INSERT INTO book(book_id, customer_id, customer_name, room_id, service_id, employee_id, time_check_out) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareCall(sql);
            statement.setString(1, booking.getBookId());
            statement.setString(2, booking.getCustomerId());
            statement.setString(3, booking.getCustomerName());
            statement.setString(4, booking.getRoomID());
            statement.setString(5, booking.getServiceId());
            statement.setString(6, booking.getEmployeeId());

            statement.setDate(7, booking.getTimeCheckOut());

            // TODO: String.format
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            CloseDB.closeStatement(statement);
        }
        return true;
    }

    public void deleteBooking(String bookingId) {
        PreparedStatement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            final String sql = "DELETE FROM book WHERE room_id = ?";
            statement = con.prepareCall(sql);
            statement.setString(1, bookingId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
    }

    public long rentalTimes() {
        long rentalTimes = 0;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT COUNT(*) FROM book";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    rentalTimes = result.getLong(1);

                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rentalTimes;

    }

    public String regularRoom() {
        String regularRoom = null;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select r.name from book b inner join room r on b.room_id = r.room_id\n"
                    + "	group by r.name having count(r.name) >= ALL (\n"
                    + "	select count(r.name) from book b inner join room r on b.room_id = r.room_id\n"
                    + "	group by r.name\n"
                    + ")\n"
                    + "LIMIT 1";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    regularRoom = result.getString(1);

                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return regularRoom;

    }
}
