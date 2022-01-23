package com.s3javaExpend.wh3.controller;

import com.s3javaExpend.wh3.dto.ResidentDto;
import com.s3javaExpend.wh3.model.Resident;
import com.s3javaExpend.wh3.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resident> createResident(@RequestBody ResidentDto residentDto) {
        Resident resident = residentService.createResident(
                residentDto.getFirstName(),
                residentDto.getLastName(),
                residentDto.getRoomId());
        return ResponseEntity.status(HttpStatus.CREATED).body(resident);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        residentService.delete(id);
    }

}
