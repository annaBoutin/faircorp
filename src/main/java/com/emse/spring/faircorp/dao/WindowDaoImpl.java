package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
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

    @Override
    public  List<Window> findByRoomId(Long id){
        return em.createQuery("select c from Window c inner join c.room s where s.id = :id",
                Window.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }


}
