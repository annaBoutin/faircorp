package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    private RoomDao roomDao;
    private BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao){
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> findAll(){
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        // WindowDto must always contain the window room
        //Building building = buildingDao.getOne(dto.getBuildingId());
        Room room = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName()));
        }
        else {
            room = roomDao.getOne(dto.getId());  // (9)
            room.setFloor(dto.getFloor());
            room.setCurrentTemp(dto.getCurrentTemp());
            room.setTargetTemp(dto.getTargetTemp());
        }
        return new RoomDto(room);
    }



}
