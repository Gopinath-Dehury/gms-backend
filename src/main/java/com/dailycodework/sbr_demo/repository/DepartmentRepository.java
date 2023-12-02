package com.dailycodework.sbr_demo.repository;

import com.dailycodework.sbr_demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository< Department, Long> {

}
