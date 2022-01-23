package com.s3javaExpend.wh3.service.impl;


import com.s3javaExpend.wh3.model.Resident;
import com.s3javaExpend.wh3.model.Room;
import com.s3javaExpend.wh3.repository.ResidentRepository;
import com.s3javaExpend.wh3.repository.RoomRepository;
import com.s3javaExpend.wh3.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResidentServiceImpl implements ResidentService {
    private ResidentRepository residentRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ResidentServiceImpl(ResidentRepository residentRepository, RoomRepository roomRepository) {
        this.residentRepository = residentRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Resident createResident(String firstName, String lastName, Long roomId) {
        Resident resident = new Resident();
        Room room = roomRepository.getById(roomId);
        room.setFreeSeat(room.getFreeSeat() - 1);
        resident.setRoom(room);
        resident.setFirstName(firstName);
        resident.setLastName(lastName);
//        roomRepository.save(room);
        return residentRepository.save(resident);
    }

    @Override
    public void delete(Long id) {
        Resident resident = residentRepository.getById(id);
        Room room = resident.getRoom();
        room.setFreeSeat(room.getFreeSeat() + 1);
        resident.setRoom(null);
        residentRepository.save(resident);
    }
}
