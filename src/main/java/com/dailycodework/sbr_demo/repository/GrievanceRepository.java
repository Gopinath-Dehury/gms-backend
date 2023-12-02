package com.dailycodework.sbr_demo.repository;

import com.dailycodework.sbr_demo.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrievanceRepository extends JpaRepository<Grievance,Long> {
   // Optional<Grievance> findByRegdNo(String student_regd_no);

}
