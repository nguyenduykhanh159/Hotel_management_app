package com.hust.hotelproject.util;

import java.util.Date;

public final class Logger {
	private Logger() {}
	
	public static void error(String msg) {
		System.out.println("ERROR: " + msg);
	}
	
	public static void info(String msg) {
		System.out.println(new Date() + " - INFO: " + msg);
	}
}
