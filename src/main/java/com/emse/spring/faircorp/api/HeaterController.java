package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {
    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao){
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll(){
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = roomDao.getOne(dto.getRoomId());
        Heater heater = null;
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), room, dto.getHeaterStatus()));
        }
        else {
            heater = heaterDao.getOne(dto.getId());  // (9)
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setPower(dto.getPower());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }

}
