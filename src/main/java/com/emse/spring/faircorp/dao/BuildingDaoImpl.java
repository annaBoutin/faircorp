package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BuildingDaoImpl implements BuildingCustomDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Window> findBuildingWindow(Long id) {
        String jpql = "select w from Window w where w.room.building = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();

    }
}
