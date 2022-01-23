package com.s3javaExpend.wh3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private boolean isRemoved;
    private LocalDateTime created;

}
