package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    List<Student> findByFirstName(String firstname);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);



    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);



    //Native
    @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    //Native Name Param
    //what is name parameter?
    @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //to modify the values in our table we are going to add the annotation @ Modifying
    @Modifying
    // we are going to do this, suppose we have an operation where we have to run three queries and if one of them fails and its annotated with @Transactional if all of them are successful it will stay or all of them are rolled back
    @Transactional
    @Query(
           value = "update tbl_student set first_name = ?1 where email_address = ?2",
           nativeQuery = true
    )
    int updateStudentNameByEmail(String firstName, String emailId);


}
