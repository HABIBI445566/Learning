package com.zahimuslim.Spring_boot_learning.controller;

import com.zahimuslim.Spring_boot_learning.entity.Department;
import com.zahimuslim.Spring_boot_learning.error.DepartmentNotFoundException;
import com.zahimuslim.Spring_boot_learning.service.DepartmentService;
import com.zahimuslim.Spring_boot_learning.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //two types of autowiring, constructor based and setter based
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments") // telling spring to convert the request to Department object
    public Department saveDepartment( @Valid @RequestBody Department department)
    {
        logger.info("Inside Save Dept of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        logger.info("Inside Save Dept of fetchDepartmentList Controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departmentById/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }


    @DeleteMapping("/deleteDepartmentById/{id}")
    public String deleteDepartmentBydId(@PathVariable("id") Long id)
    {
        departmentService.deleteDepartmentById(id);
        return "Department Deleted Successfully!!";
    }


    @PutMapping("/departments/{id}")
    public Department updateDepartment( @PathVariable("id") Long id, @RequestBody Department department)
    {
        return departmentService.updateDepartment(id,department);
    }


    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String deprtmentName)
    {
        return departmentService.getDepartmentByName(deprtmentName);
    }
 }
