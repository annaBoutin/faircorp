package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WindowDaoImpl implements WindowCustomDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findByRoomName(String roomName) {
        return em.createQuery("select c from Window c inner join c.room s where s.name = :roomName",
                Window.class)
                .setParameter("roomName", "%" + roomName.toLowerCase() + "%")
                .getResultList();
    }
}
