package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Course;
import com.zahimuslim.Spring_boot_learning.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    // there is something called cascadding which will make it to persist this test failed because we tried to save a CourseMaterial without saving the Course First
    @Test
    public void SaveCourseMaterial()
    {
        Course course = Course.builder()
                .title("new")
                .credit(7)
                .build();


        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.new.com")
                      //  .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials()
    {
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println("Course Materials -->"+courseMaterialList);
    }

}