package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {
    private Long id;
    private Double outsideTemp;

    public BuildingDto(){

    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.outsideTemp = building.getOutsideTemp();
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
}
