package com.zahimuslim.Spring_boot_learning.service;

import com.zahimuslim.Spring_boot_learning.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department getDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String deprtmentName);
}
