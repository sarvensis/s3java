package com.s3javaExpend.wh3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "room.id", nullable = true)
    private Room room;
}
