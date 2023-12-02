package com.dailycodework.sbr_demo.service;

import com.dailycodework.sbr_demo.model.Department;

import java.util.List;

public interface IDepartmentService {
    Department addDepartment(Department department);
    List<Department> getDepartments();
    Department updateDepartment(Department department,Long id);
    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);
}
