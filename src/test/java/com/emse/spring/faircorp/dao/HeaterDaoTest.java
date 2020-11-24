package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAHeater() {
        Heater heater = heaterDao.getOne(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void shouldDeleteWindowsRoom() {
        Optional<Room> room = roomDao.findById(-10L);
        Assertions.assertThat(room.get().getHeaters().size()).isEqualTo(2);
        heaterDao.deleteByRoomId(-10L);
        List<Heater> result = heaterDao.findAllById(room.get().getWindows().stream().map(Window::getId).collect(Collectors.toList()));
        Assertions.assertThat(result).isEmpty();
    }
}
