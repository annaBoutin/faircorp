package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HeaterDaoImpl implements HeaterCustomDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findByRoomName(String roomName) {
        return em.createQuery("select c from Heater c inner join c.room s where s.name = :roomName",
                Heater.class)
                .setParameter("roomName", "%" + roomName.toLowerCase() + "%")
                .getResultList();
    }
}
