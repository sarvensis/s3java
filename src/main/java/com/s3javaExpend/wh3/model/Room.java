package com.s3javaExpend.wh3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "dormitory.id", nullable = true)
    private Dormitory dormitory;

    private boolean isBusy;
    private boolean needRepair;
    private int numberOfSeats;
    private int freeSeat;
}
