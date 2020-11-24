package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomCustomDao {
    List<Room> findByWindowOpen();
    List<Room> findByName(String name);
}
