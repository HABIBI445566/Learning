package com.zahimuslim.Spring_boot_learning.service;

import com.zahimuslim.Spring_boot_learning.entity.Department;
import com.zahimuslim.Spring_boot_learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
