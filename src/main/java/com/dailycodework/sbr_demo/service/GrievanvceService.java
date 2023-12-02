package com.dailycodework.sbr_demo.service;

import com.dailycodework.sbr_demo.exception.ResourceNotFoundException;
import com.dailycodework.sbr_demo.exception.StudentNotFoundException;
import com.dailycodework.sbr_demo.model.Grievance;
import com.dailycodework.sbr_demo.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GrievanvceService implements IGrievanceService{
//    @Override
//    public Grievance addGrievance(Grievance grievance) {
//        return null;
//    }
//
//    @Override
//    public List<Grievance> getGrievances() {
//        return null;
//    }
//
//    @Override
//    public Grievance updategrievance(Grievance grievance, Long id) {
//        return null;
//    }
//
//    @Override
//    public Grievance getGrievanceById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//
//    }


    @Autowired
    private final GrievanceRepository grievanceRepository;


    public GrievanvceService(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    @Override
    public Grievance addGrievance(Grievance grievance) {
        grievance.setCreatedDate(LocalDateTime.now());
        grievance.setStatus("pending");
        return grievanceRepository.save(grievance);
    }


    @Override
    public List<Grievance> getGrievances() {
        return grievanceRepository.findAll();
    }

    @Override
    public Grievance getGrievanceById(Long id) {
        Optional<Grievance> grievance = grievanceRepository.findById(id);
        return grievance.orElse(null);
    }

//    @Override
//    public Grievance getGrievanceByRegdNo(String student_regd_no) {
//        return grievanceRepository.findByRegdNo(student_regd_no).orElseThrow(()->new StudentNotFoundException("sorry grievance not found"+student_regd_no));
//    }


    @Override
    public Grievance updateGrievanceById(Long id,Grievance updatedGrievance) {
        Optional<Grievance> existingGrievance = grievanceRepository.findById(id);
        if (existingGrievance.isPresent()) {
            Grievance grievance = existingGrievance.get();
            grievance.setDescription(updatedGrievance.getDescription());
            grievance.setResolvedDate(LocalDateTime.now());
            grievance.setStatus("resolved");
            return grievanceRepository.save(grievance);
        }
        return null; // Grievance with given ID not found
    }

    //    @Override
//    public String deleteGrievanceById(long id) {
//        grievanceRepository.deleteById(id);
//    }
    @Override
    public Grievance deleteGrievanceById(Long id) {
        Grievance existingGrievance = grievanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grievance","ID",id));

        grievanceRepository.delete(existingGrievance);
        return existingGrievance;


    }
}
