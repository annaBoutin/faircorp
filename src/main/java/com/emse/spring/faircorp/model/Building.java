package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double outsideTemp;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOutsideTemp() {
        return outsideTemp;
    }

    public void setOutsideTemp(Double outsideTemp) {
        this.outsideTemp = outsideTemp;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
