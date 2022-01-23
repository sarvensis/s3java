package com.s3javaExpend.wh3.service.impl;

import com.s3javaExpend.wh3.model.Dormitory;
import com.s3javaExpend.wh3.repository.DormitoryRepository;
import com.s3javaExpend.wh3.service.DormitoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    private DormitoryRepository dormitoryRepository;

    public DormitoryServiceImpl(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    @Override
    public Dormitory createDormitory(String name, String address) {
        Dormitory dormitory = new Dormitory();
        dormitory.setName(name);
        dormitory.setAddress(address);
        dormitory.setRemoved(false);
        dormitory.setCreated(LocalDateTime.now());
        return dormitoryRepository.save(dormitory);
    }

    @Override
    public Dormitory updateDormitory(Long dormitoryId, String address, String name) {
        Dormitory dormitory = dormitoryRepository.getById(dormitoryId);
        dormitory.setName(name);
        dormitory.setAddress(address);
        return dormitoryRepository.save(dormitory);
    }

    @Override
    public void delete(Long id) {
        Dormitory dormitory = dormitoryRepository.getById(id);
        dormitory.setRemoved(true);
        dormitoryRepository.save(dormitory);
    }

    @Override
    public Dormitory getById(Long dormitoryId) {
        Dormitory dormitory = dormitoryRepository.getById(dormitoryId);
        return dormitory;
    }

    @Override
    public List<Dormitory> getAll() {
        return dormitoryRepository.findAll();
    }
}
