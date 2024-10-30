package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Guardian;
import com.zahimuslim.Spring_boot_learning.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest // we shouldnt really test repository  with @SpringBootTest we are should use @DataJpaTest for it since we want your DB to be impacted and not flushed after the use we are using the @SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {

        Guardian guardian =  Guardian.builder()
                .name("Habib")
                .email("hello@gmail.com")
                .mobile("123429234")
                .build();



    Student student = Student.builder()
        .emailId("shabbisr@gmail.com")
                .firstName("Shabdbir")
                .lastName("Dawoocdi")
                .guardian(guardian)
                .build();

    studentRepository.save(student);

    }

    @Test
    public void printAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining()
    {
        List<Student> studentList = studentRepository.findByFirstNameContaining("ha");
        System.out.println(studentList);
    }

    @Test

    public void printStudentBasedOnGuardianName()
    {
        List<Student> students = studentRepository.findByGuardianName("Habib");
        System.out.println(students);
    }


    @Test
    public void printGetStudentByEmailAddress()
    {
        Student student = studentRepository.getStudentByEmailAddress("shabbisr@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeTesting()
    {
        Student student = studentRepository.getStudentByEmailAddressNative("shabbisr@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeParamTesting()
    {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shabbisr@gmail.com");
        System.out.println(student);
    }

}