package com.s3javaExpend.wh3.repository;

import com.s3javaExpend.wh3.model.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
//    List<Dormitory> findByName(String name);
}
