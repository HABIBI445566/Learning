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


    @Test
    public void printFindByTileContaining()
    {
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("courses -->"+courses);

    }



/*
    @Test
    public void findAllPagination() {
        // Creating a Pageable instance for pagination:
        // 'firstPageWithThreeRecords' - retrieves the first page with 3 records per page.
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        // 'secondPageWithTwoRecords' - retrieves the second page with 2 records per page.
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        // Fetching pagination details for 'secondPageWithTwoRecords'

        // Gets the total number of records in the database for 'Course' entity.
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        System.out.println("Total Elements -->" + totalElements); // Prints total number of Course records.

        // Gets the total number of pages available based on the specified page size (2 records per page).
        int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("Total Pages -->" + totalPages); // Prints total pages based on the page size.

        // Retrieves the list of 'Course' records for 'secondPageWithTwoRecords'.
        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        System.out.println("courses -->" + courses); // Prints courses on the second page with 2 records per page.
    }

    @Test
    public void findAllWithSorting() {
        // Creating Pageable instances with sorting options:

        // 'sortByTitle' - sorts records by 'title' in ascending order (default).
        Pageable sortByTitle = PageRequest.of(0, 6, Sort.by("title"));
        // 'sortByCreditDec' - sorts records by 'credit' in descending order.
        Pageable sortByCreditDec = PageRequest.of(0, 6, Sort.by("credit").descending());
        // 'sortByTitleAndCreditDesc' - sorts by 'title' in descending order first, then by 'credit' in ascending order.
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 6, Sort.by("title").descending().and(Sort.by("credit")));

        // Fetching sorted data based on different sorting criteria:

        // Retrieves 'Course' records sorted by 'title' in ascending order.
        List<Course> listOfsortByTitle = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("listOfsortByTitle -->" + listOfsortByTitle);

        // Retrieves 'Course' records sorted by 'credit' in descending order.
        List<Course> listOfsortByCreditDec = courseRepository.findAll(sortByCreditDec).getContent();
        System.out.println("listOfsortByCreditDec -->" + listOfsortByCreditDec);

        // Retrieves 'Course' records sorted by 'title' in descending order, then by 'credit' in ascending order.
        List<Course> listOfsortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("listOfsortByTitleAndCreditDesc -->" + listOfsortByTitleAndCreditDesc);
    }

    @Test
    public void printFindByTileContaining() {
        // Creating a Pageable instance for retrieving a limited number of records:
        // 'firstPageTenRecords' - retrieves the first page with a maximum of 10 records.
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        // Retrieves 'Course' records where the title contains the letter "D" (case-sensitive) using pagination.
        // Limits the result to 10 records (or less if there are fewer matches).
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses -->" + courses); // Prints courses where the title contains "D".
    }*/


}