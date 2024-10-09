package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // we need to pas the entity and the Id type
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //Definitely check how this is actually working
    public Department findByDepartmentName(String departmentName);
}
