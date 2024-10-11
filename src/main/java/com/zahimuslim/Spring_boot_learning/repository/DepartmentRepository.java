package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // we need to pas the entity and the Id type
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //Definitely check how this is actually working
    public Department findByDepartmentName(String departmentName);

    /*
    * There is a link in the website where we can write the function name and it will fetch the values for us,
    * but if you want to write the SQL query yourself then you can do it this way
    * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    * */

   /* @Query(value = "",nativeQuery = true)
    public Department findByDepartmentNameIgnoreCase(String departmentName);*/
}
