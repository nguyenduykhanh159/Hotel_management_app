package com.hust.hotelproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.model.dao.*;
import com.hust.hotelproject.model.dto.UserDto;
import com.hust.hotelproject.model.entity.User;
import com.hust.hotelproject.util.PasswordHashing;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginController {

    public List<User> returnAllUser() {
        List<User> listuser = new ArrayList<User>();
        UserDao userdao = new UserDao();
        listuser = userdao.getAllUser();
        return listuser;
    }

    public UserDto checkUser(String username, String passwordInput) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user = null;
        if (username == null || username.isEmpty()) {
            return new UserDto(null, "Username empty");
        }
        
        String password = PasswordHashing.hashing(passwordInput);
        System.out.println(password);
        
        UserDao userDao = new UserDao();
        user = userDao.findUser(username);
        if (user == null) {
            return new UserDto(null, "Not exist user");
        }

        if (!user.getPassword().equals(password)) {
            return new UserDto(null, "Wrong password");
        }

        return new UserDto(user, "login Success");
    }

}
