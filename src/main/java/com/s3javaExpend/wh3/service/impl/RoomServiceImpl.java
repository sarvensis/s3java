package com.s3javaExpend.wh3.service.impl;

import com.s3javaExpend.wh3.model.Dormitory;
import com.s3javaExpend.wh3.model.Room;
import com.s3javaExpend.wh3.repository.RoomRepository;
import com.s3javaExpend.wh3.service.DormitoryService;
import com.s3javaExpend.wh3.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private DormitoryService dormitoryService;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, DormitoryService dormitoryService) {
        this.roomRepository = roomRepository;
        this.dormitoryService = dormitoryService;
    }


    @Override
    public Room createRoom(String title, Long dormitoryId, boolean busy, boolean needRepair, int numberOfSeats, int freeSeat) {
        Room room = new Room();
        Dormitory dormitory = dormitoryService.getById(dormitoryId);
        room.setTitle(title);
        room.setDormitory(dormitory);
        room.setBusy(busy);
        room.setNeedRepair(needRepair);
        room.setNumberOfSeats(numberOfSeats);
        room.setFreeSeat(freeSeat);
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long roomId, String title, Long dormitoryId, boolean busy, boolean needRepair, int numberOfSeats, int freeSeat) {
        Room room = roomRepository.getById(roomId);
        room.setTitle(title);
        Dormitory dormitory = dormitoryService.getById(dormitoryId);
        room.setDormitory(dormitory);
        room.setBusy(busy);
        room.setNeedRepair(needRepair);
        room.setNumberOfSeats(numberOfSeats);
        room.setFreeSeat(freeSeat);
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
