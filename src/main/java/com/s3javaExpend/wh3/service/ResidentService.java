package com.s3javaExpend.wh3.service;

import com.s3javaExpend.wh3.model.Resident;

public interface ResidentService {
    Resident createResident(String firstName, String lastName, Long roomId);

    void delete(Long id);
}
