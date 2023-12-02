package com.dailycodework.sbr_demo.controller;


import com.dailycodework.sbr_demo.model.Grievance;
import com.dailycodework.sbr_demo.service.IGrievanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/grievance")
@RequiredArgsConstructor
public class GrievanceController {

    private final IGrievanceService grievanceService;



    //save Grievance
    @PostMapping("/save")
    public ResponseEntity<Grievance> saveGrievance(@RequestBody Grievance grievance) {
        //Grievance saveGrievance = grievanceService.saveGrievance(grievance);
        return new ResponseEntity<Grievance>(grievanceService.addGrievance(grievance), HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Grievance>> getGrievances() {
//	        List<Grievance> grievances = grievanceService.getAllGrievances();
        return new ResponseEntity<>(grievanceService.getGrievances(),HttpStatus.FOUND);
    }
//		@GetMapping("getbyid/{id}")
//			public ResponseEntity<Grievance> getGrievanceById(@PathVariable("id") Long gid) {
//				return new ResponseEntity<Grievance>(grievanceService.getGrievanceById(gid),HttpStatus.OK);
//			}


    //GET THE GRIEVANCE BY ID
    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getGrievanceById1(@PathVariable Long id) {
        Grievance grievance = grievanceService.getGrievanceById(id);
        if (grievance != null) {
            return ResponseEntity.ok(grievance);
        } else {
            String errorMessage = "Grievance with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

//    @GetMapping("getbyregdno/{student_regd_no}")
//    public ResponseEntity<?> getGrievanceByRegdNo(@PathVariable String student_regd_no) {
//        Grievance grievance = grievanceService.getGrievanceByRegdNo(student_regd_no);
//        if (grievance != null) {
//            return ResponseEntity.ok(grievance);
//        } else {
//            String errorMessage = "Grievance with ID " + student_regd_no + " not found.";
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
//        }
//    }
//


//    @PostMapping("/{id}/grievances")
//    public ResponseEntity<Grievance> saveGrievance(@PathVariable long id, @RequestBody Grievance grievance) {
//        // Assuming you have a service method to retrieve the student by ID
//        Student student = studentService.getStudentById(id);
//        if (student == null) {
//            // Handle the case where the student with the given ID is not found
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        //grievance.setStudent(student); // Set the student object in Grievance
//
//        Grievance savedGrievance = grievanceService.saveGrievance(grievance);
//        return new ResponseEntity<>(savedGrievance, HttpStatus.CREATED);
//    }




    //UPDATE GRIEVANCE BY ID
    @PutMapping("updatebyid/{id}")
    public ResponseEntity<?> updateGrievance(@PathVariable Long id, @RequestBody Grievance updatedGrievance) {
        Grievance grievance = grievanceService.updateGrievanceById(id, updatedGrievance);
        if (grievance != null) {
            return ResponseEntity.ok(grievance);
        } else {
            String errorMessage = "Grievance with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    //DELETE GRIEVANCE BY ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteGrievance(@PathVariable Long id) {
        Grievance deletedgrievance=grievanceService.deleteGrievanceById(id);
        if (deletedgrievance != null) {
            String responseMessage = "Grievance with ID "+id+" has been deleted successfully.";
            return ResponseEntity.ok(responseMessage);
        } else {
            String errorMessage = "Grievance with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
