package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomCustomDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Room> findByWindowOpen() {
        return em.createQuery("select c from Room c inner join c.windows s where s.windowStatus = :status",
                Room.class)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public List<Room> findByName(String name) {
        return em.createQuery("select c from Room c where c.name = :name", Room.class)
                .setParameter("name", name)
                .getResultList();
    }
}
