package com.zahimuslim.Spring_boot_learning;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//to make the system know that we have an entity that we would be mapping it with DB
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// we had already run the program without the below annotation, and it built, we got all the fields that we want in the Table when we opened work bench, now we will be running the application by adding The below annotation and we see that this created a new Table
@Table(name = "tbl_student")
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long studentId;
    private String firstName;
    private String lastNme;
    //this will say how our column should be named if we want
    //@Column(name = "email_address")
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
