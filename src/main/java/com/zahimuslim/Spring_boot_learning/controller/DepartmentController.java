package com.zahimuslim.Spring_boot_learning.controller;

import com.zahimuslim.Spring_boot_learning.entity.Department;
import com.zahimuslim.Spring_boot_learning.service.DepartmentService;
import com.zahimuslim.Spring_boot_learning.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    //two types of autowiring, constructor based and setter based
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments") // telling spring to convert the request to Department object
    public Department saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }
}
