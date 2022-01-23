package com.s3javaExpend.wh3.dto;

import lombok.Data;

@Data
public class RoomDto {
    private String title;
    private Long dormitoryId;
    private boolean isBusy;
    private boolean needRepair;
    private int numberOfSeats;
    private int freeSeat;
}
