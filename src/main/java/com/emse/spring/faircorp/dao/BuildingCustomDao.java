package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface BuildingCustomDao {
    List<Window> findBuildingWindow(Long id);
}
