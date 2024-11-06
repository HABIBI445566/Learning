package com.zahimuslim.Spring_boot_learning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    // we are telling in Course material class we have course attribute
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    // this way there wont be any change in the DB
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    //hch check how this works
    //this table contains the mapping of two already containing tables
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            //Table name
            name = "Student_course_mapping",
            joinColumns = @JoinColumn(
                    //DB column name
                    name = "course_id",
                    //class property
                    referencedColumnName = "courseId"
            ),
            //for student
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student)
    {
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }


}

