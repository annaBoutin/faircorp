package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import java.util.List;

public interface HeaterCustomDao {
    List<Heater> findByRoomName(String roomName);
}
