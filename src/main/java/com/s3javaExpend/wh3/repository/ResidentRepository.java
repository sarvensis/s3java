package com.s3javaExpend.wh3.repository;

import com.s3javaExpend.wh3.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
}
