/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.model.dao;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Bill;
import com.hust.hotelproject.model.entity.Booking;
import com.hust.hotelproject.model.entity.Room;
import com.hust.hotelproject.util.CloseDB;
import com.hust.hotelproject.util.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangminh
 */
public class BillDao {

    public Bill findBillId(String billId) {

        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM bill WHERE book_id = '" + billId + "'";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Bill bill = new Bill(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getDate(6).toString(), result.getDate(7).toString(), result.getLong(8));
                    System.out.println(bill.toString());
                    return bill;
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
        return null;
    }

    public long totalIncome() {
        long totalIncome = 0;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT SUM(total_price) FROM bill";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    totalIncome = result.getLong(1);

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
        return totalIncome;
    }

    public String regularCustomer() {
        String regularCustomer = null;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT customer_name FROM bill\n"
                    + "group by customer_name having count(*) >= ALL(\n"
                    + "SELECT count(*) FROM bill\n"
                    + "group by customer_name)\n"
                    + "LIMIT 1";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    regularCustomer = result.getString(1);

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
        return regularCustomer;
    }

    public String vipCustomer() {
        String regularCustomer = null;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT customer_name FROM bill\n"
                    + "group by customer_name having sum(total_price) >= ALL(\n"
                    + "SELECT sum(total_price) FROM bill\n"
                    + "group by customer_name)\n"
                    + "LIMIT 1";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    regularCustomer = result.getString(1);

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
        return regularCustomer;
    }

}
