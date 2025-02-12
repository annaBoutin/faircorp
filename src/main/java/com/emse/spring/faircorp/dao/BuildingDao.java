package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long>, BuildingCustomDao {
}
