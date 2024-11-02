package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Course;
import com.zahimuslim.Spring_boot_learning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    //usually we get the Course material with the Course we havent established anything which would reference the course material, this is a unidirectional relationship, we will make thi bidirectional
    @Test
    public void printCourses()
    {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses --> "+courses);
    }

    @Test
    public void SaveCourseWithTeacher()
    {

        Teacher teacher = Teacher.builder()
                .firstName("Vinay")
                .lastName("B")
                .build();

        Course course = Course.builder()
                        .title("Python")
                                .credit(8)
                                        .teacher(teacher)
                                                .build();

        courseRepository.save(course);

    }

}