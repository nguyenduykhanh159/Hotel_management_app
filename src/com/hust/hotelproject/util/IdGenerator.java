package com.hust.hotelproject.util;

import java.util.Random;

public class IdGenerator {
	private static final String ALPHABET = "abcdefghijklmnoqprstuvxyzw0123456789";
	
	public static String generateEmployeeId(int length) {
		String id = "";
		
		for (int i = 0; i < length; i++) {
			Random random = new Random();
			int value = random.nextInt(36);
			id += ALPHABET.charAt(value);
		}
		
		return id;
	}
}
