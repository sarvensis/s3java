package com.s3javaExpend.wh3.service;

import com.s3javaExpend.wh3.model.Dormitory;

import java.util.List;

public interface DormitoryService {
    Dormitory createDormitory(String name, String address);

    Dormitory updateDormitory(Long dormitoryId, String address, String name);

    void delete(Long id);

    Dormitory getById(Long dormitoryId);

    List<Dormitory> getAll();
}
