package com.dailycodework.sbr_demo.service;

import com.dailycodework.sbr_demo.model.Grievance;

import java.util.List;

public interface IGrievanceService {

    Grievance addGrievance(Grievance grievance);
    List<Grievance> getGrievances();
    Grievance updateGrievanceById(Long id,Grievance grievance);
    Grievance getGrievanceById(Long id);
    //Grievance getGrievanceByRegdNo(String student_regd_no);
    Grievance deleteGrievanceById(Long id);


}
