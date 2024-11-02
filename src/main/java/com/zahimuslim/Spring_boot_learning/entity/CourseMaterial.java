package com.zahimuslim.Spring_boot_learning.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
   private Long courseMaterialId;
   private String url;


   //there are multiple types of fetch available if its lazy then its not going to get the Course Data, its eager then its also going to get the data from the table
   //over here we are mentioning what kind of relationship we have and what column it is refrencing to
   @OneToOne(
           //ask about this later
           cascade = CascadeType.ALL,
           fetch = FetchType.LAZY
   )
   @JoinColumn(
           name = "course_id",
           referencedColumnName = "courseId"
   )
   private Course course;
}
