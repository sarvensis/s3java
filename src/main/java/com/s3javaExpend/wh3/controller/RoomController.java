package com.s3javaExpend.wh3.controller;

import com.s3javaExpend.wh3.dto.DormitoryDto;
import com.s3javaExpend.wh3.dto.RoomDto;
import com.s3javaExpend.wh3.model.Dormitory;
import com.s3javaExpend.wh3.model.Room;
import com.s3javaExpend.wh3.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Room> createRoom(@RequestBody RoomDto roomDto) {
        Room room = roomService.createRoom(
                roomDto.getTitle(),
                roomDto.getDormitoryId(),
                roomDto.isBusy(),
                roomDto.isNeedRepair(),
                roomDto.getNumberOfSeats(),
                roomDto.getFreeSeat());
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Room> updateDormitory(@RequestBody RoomDto roomDto, @PathVariable("id") Long roomId) {
        Room room = roomService.updateRoom(
                roomId,
                roomDto.getTitle(),
                roomDto.getDormitoryId(),
                roomDto.isBusy(),
                roomDto.isNeedRepair(),
                roomDto.getNumberOfSeats(),
                roomDto.getFreeSeat());
        return ResponseEntity.ok(room);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> room = roomService.getAll();
        return ResponseEntity.ok(room);
    }

}
