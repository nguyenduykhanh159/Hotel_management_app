/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.hotelproject.util;
import com.hust.hotelproject.model.entity.Bill;
import java.io.FileWriter;
import java.lang.String;
/**
 *
 * @author hoangminh
 */
public class ExportBill {
    public static void bill(Bill bill) {
        String billForm = "HOTEL KHANH - MINH\n" +
        "==================\n" +
        "======BILL========\n" +
        "BILLID: %s\n" +
        "NAME: %s\n" +
        "ROOM: %s\n" +
        "SERVICE: %s\n" +
        "TIME IN: %s\n" +
        "TIME OUT: %s\n" +
        "PRICE: %d\n" +
        "EMPLOYEE:%s";
        
        System.out.println(billForm);
        System.out.println(bill.toString());
        String billExport = String.format(billForm, bill.getBookingId(), bill.getCustomerName(), bill.getRoomName(), bill.getServiceName(), bill.getTimeIn(), bill.getTimeOut(), bill.getPrice(), bill.getEmployeeName());
        try {
            FileWriter fw = new FileWriter("E:\\Code_Jv\\DB_Project\\Bill");
            fw.write(billExport);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
