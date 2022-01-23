package com.s3javaExpend.wh3.service;

import com.s3javaExpend.wh3.model.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(String title, Long dormitoryId, boolean busy, boolean needRepair,
                    int numberOfSeats, int freeSeat);

    Room updateRoom(Long roomId, String title, Long dormitoryId, boolean busy,
                    boolean needRepair, int numberOfSeats, int freeSeat);

    List<Room> getAll();
}
