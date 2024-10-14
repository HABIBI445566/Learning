package com.zahimuslim.Spring_boot_learning.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


//in order for this class to interact with the DB, we need to annotate this with @Entity
@Entity
@Data // This is equivalant to @ Getters and setters if you want them particulary you can do @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // will get Builder Pattern
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message = "Please Add Department Name")
  /*  @Length(max = 5, min =1)

    //email validations
    @Email

    //numbers
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero

    //dates
    @Future
    @FutureOrPresent

    @Past
    @PastOrPresent*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
