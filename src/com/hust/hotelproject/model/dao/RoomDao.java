package com.hust.hotelproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hust.hotelproject.database.DBConnect;
import com.hust.hotelproject.model.entity.Room;
import com.hust.hotelproject.util.CloseDB;
import com.hust.hotelproject.util.Logger;

public class RoomDao {

    public List<Room> getAllRoom() {
        List<Room> listRoom = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select * from room";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Room room = new Room(result.getString(1), result.getString(2), result.getLong(3), result.getString(4), result.getString(5));
                    listRoom.add(room);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return listRoom;
    }

    public List<Room> findRoom(String name) {
        List<Room> listRoom = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select * from room where name LIKE '%" + name + "%'";
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Room employee = new Room(result.getString(1), result.getString(2), result.getLong(3), result.getString(4), result.getString(5));
                    listRoom.add(employee);
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
        return listRoom;
    }

    public boolean insertRoom(Room room) {
        PreparedStatement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            final String sql = "INSERT INTO room VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareCall(sql);
            statement.setString(1, room.getRoomId());
            statement.setString(2, room.getType());
            statement.setLong(3, room.getPrice());
            statement.setString(4, room.getStatus());
            statement.setString(5, room.getName());

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

    public void deleteRoom(String roomId) {
        PreparedStatement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            final String sql = "DELETE FROM room WHERE room_id = ?";
            statement = con.prepareCall(sql);
            statement.setString(1, roomId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
    }

    public List<Room> maxRoom() {
        List<Room> listRoom = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM room "
                    + "WHERE price >= ALL("
                    + "SELECT max(price) from room)";
            Logger.info(sql);
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Room room = new Room(result.getString(1), result.getString(2), result.getLong(3), result.getString(4), result.getString(5));
                    listRoom.add(room);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return listRoom;
    }

    public List<Room> minRoom() {
        List<Room> listRoom = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM room "
                    + "WHERE price <= ALL("
                    + "SELECT min(price) from room)";
            Logger.info(sql);
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Room room = new Room(result.getString(1), result.getString(2), result.getLong(3), result.getString(4), result.getString(5));
                    listRoom.add(room);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return listRoom;
    }

    public List<Room> arrangeRoom() {
        List<Room> listRoom = new ArrayList<>();
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM room"
                    + " order by price DESC";
            Logger.info(sql);
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    Room room = new Room(result.getString(1), result.getString(2), result.getLong(3), result.getString(4), result.getString(5));
                    listRoom.add(room);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return listRoom;
    }

    public int refreshRoom() {
        int countUpdate = 0;
        Statement statement = null;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT check_time_out_func(current_date)";
            Logger.info(sql);
            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);
            try {
                while (result.next()) {
                    countUpdate = result.getInt(1);
                }
            } finally {
                CloseDB.closeResultSet(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseDB.closeStatement(statement);
        }
        return countUpdate;
    }

}
