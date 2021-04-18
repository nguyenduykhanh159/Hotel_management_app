package com.hust.hotelproject;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.util.PasswordHashing;
import com.hust.hotelproject.view.LoginView;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class App {

	public static void main(String[] args) {
		//Connect database
		DBConnect.getConnection();

		LoginView.runFrame();
            
	}

}
