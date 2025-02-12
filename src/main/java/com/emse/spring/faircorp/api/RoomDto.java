package com.emse.spring.faircorp.api;


import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private Integer floor;
    private String name;
    private Double currentTemp;
    private Double targetTemp;
    private Long buildingId;

    public RoomDto(){

    }

    public RoomDto(Room room){
        this.id = room.getId();
        this.floor = room.getFloor();
        this.name = room.getName();
        this.currentTemp = room.getCurrentTemp();
        this.targetTemp = room.getTargetTemp();
        //this.buildingId = room.getBuilding().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    //public Long getBuildingId() {
    //    return buildingId;
    //}

    //public void setBuildingId(Long buildingId) {
    //    this.buildingId = buildingId;
    //}
}
