package com.dailycodework.sbr_demo.service;

import com.dailycodework.sbr_demo.model.Department;
import com.dailycodework.sbr_demo.model.Student;
import com.dailycodework.sbr_demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{


    private final DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return null;
    }

    @Override
    public List<Department> getDepartments() {
        return null;
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        return null;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {

    }
}
