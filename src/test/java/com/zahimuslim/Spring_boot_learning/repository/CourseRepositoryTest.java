package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Course;
import com.zahimuslim.Spring_boot_learning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
                        .title("NLP")
                                .credit(8)
                                        .teacher(teacher)
                                                .build();

        courseRepository.save(course);

    }

    //hch get comments on this and deep explanation
    @Test
    public void findAllPagination()
    {

        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

       /* Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println("Total Elements -->"+ totalElements);

        int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("Total Pages -->"+ totalPages);


        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courses -->"+ courses);

Total Elements -->5
Total Pages -->2
courses -->[Course(courseId=1, title=Python, credit=8, courseMaterial=null, teacher=Teacher(teacherId=1, firstName=Vinay, lastName=B)), Course(courseId=2, title=DBA, credit=8, courseMaterial=null, teacher=Teacher(teacherId=2, firstName=Vinay, lastName=B)), Course(courseId=3, title=DSA, credit=8, courseMaterial=null, teacher=Teacher(teacherId=3, firstName=Vinay, lastName=B))]


        */

        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        System.out.println("Total Elements -->"+ totalElements);

        int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("Total Pages -->"+ totalPages);


        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        System.out.println("courses -->"+ courses);

       /* Total Elements -->5
        Total Pages -->3
        courses -->[Course(courseId=3, title=DSA, credit=8, courseMaterial=null, teacher=Teacher(teacherId=3, firstName=Vinay, lastName=B)), Course(courseId=4, title=Java, credit=8, courseMaterial=null, teacher=Teacher(teacherId=4, firstName=Vinay, lastName=B))]


*/


    }
    @Test
    public void findAllWithSorting()
    {
        Pageable sortByTitle = PageRequest.of(0,6, Sort.by("title"));
        Pageable sortByCreditDec = PageRequest.of(0,6, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,6, Sort.by("title").descending().and(Sort.by("credit")));

        // i am not getting corse one for this
        List<Course> listOfsortByTitle = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("listOfsortByTitle -->"+listOfsortByTitle);
        List<Course> listOfsortByCreditDec = courseRepository.findAll(sortByCreditDec).getContent();
        System.out.println("listOfsortByCreditDec -->"+listOfsortByCreditDec);
        List<Course> listOfsortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("listOfsortByTitleAndCreditDesc -->"+listOfsortByTitleAndCreditDesc);


    }

}