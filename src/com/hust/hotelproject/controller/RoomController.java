package com.hust.hotelproject.controller;

import java.util.List;

import com.hust.hotelproject.model.dao.RoomDao;
import com.hust.hotelproject.model.entity.Room;
import com.hust.hotelproject.util.Logger;

public class RoomController {

    private RoomDao roomDao;

    public RoomController() {
        this.roomDao = new RoomDao();
    }

    public List<Room> returnAllRoom() {
        return roomDao.getAllRoom();
    }

    public List<Room> findRoom(String name) {
        return roomDao.findRoom(name);
    }

    public boolean insertRoom(Room room) {
        boolean check = roomDao.insertRoom(room);
        if (check) {
            Logger.info("Insert success");
        } else {
            Logger.error("Insert false");
        }
        return check;
    }

    public void deleteRoom(String roomId) {
        roomDao.deleteRoom(roomId);
    }

    public List<Room> maxRoom() {
        return roomDao.maxRoom();
    }
    
    public List<Room> minRoom() {
        return roomDao.minRoom();
    }
    
    public List<Room> arrangeRoom() {
        return roomDao.arrangeRoom();
    }

}
