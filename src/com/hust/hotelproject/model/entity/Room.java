package com.hust.hotelproject.model.entity;

public class Room {
	String roomId;
	String type;
	long price;
	String status;
	String name;
	
	

	public Room(String roomId, String type, long price, String status, String name) {
		super();
		this.roomId = roomId;
		this.type = type;
		this.price = price;
		this.status = status;
		this.name = name;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", name=" + name + ", price=" + price + ", status=" + status + ", type="
				+ type + "]";
	}


	
	
	
}
