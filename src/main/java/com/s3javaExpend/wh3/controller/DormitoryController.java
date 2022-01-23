package com.s3javaExpend.wh3.controller;

import com.s3javaExpend.wh3.dto.DormitoryDto;
import com.s3javaExpend.wh3.model.Dormitory;
import com.s3javaExpend.wh3.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitories")
public class DormitoryController {

    private DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Dormitory> createDormitory(@RequestBody DormitoryDto dormitoryDto) {
        System.out.print("Name " + dormitoryDto.getName() + "\n address: " + dormitoryDto.getAddress());
        Dormitory dormitory = dormitoryService.createDormitory(dormitoryDto.getName(), dormitoryDto.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(dormitory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Dormitory> updateDormitory(@RequestBody DormitoryDto dormitoryDto, @PathVariable("id") Long dormitoryId) {
        Dormitory dormitory = dormitoryService.updateDormitory(
                dormitoryId,
                dormitoryDto.getAddress(),
                dormitoryDto.getName());
        return ResponseEntity.ok(dormitory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Dormitory> getDormitoryById(@PathVariable("id") Long dormitoryId) {
        System.out.println("GET1 BY ID " + dormitoryId);
        Dormitory dormitory = dormitoryService.getById(dormitoryId);
        System.out.println("GET3 BY ID " + dormitoryId);
        System.out.println("GET4 BY ID " + dormitory);
        return ResponseEntity.ok(dormitory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDormitory(@PathVariable("id") Long id) {
        dormitoryService.delete(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Dormitory>> getDormitories() {
        List<Dormitory> dormitories = dormitoryService.getAll();
        return ResponseEntity.ok(dormitories);
    }


//    private DormitoryService dormitoryService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Dormitory> createDormitory(String name, String address) {
//        Dormitory dormitory = dormitoryService.saveDormitory()
//    }


//    public Dormitory findAll() {
//        List<Dormitory> dormitoryList = dormitoryService.findAll();
////        return
//    }
}
