package com.hust.hotelproject.model.dto;

import com.hust.hotelproject.model.entity.User;

public class UserDto {
	User user;
	String msg;
	public UserDto() {
		
	}
	
	public UserDto(User user, String msg) {
		super();
		this.user = user;
		this.msg = msg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "UserDto [user=" + user + ", msg=" + msg + "]";
	}
	
}
