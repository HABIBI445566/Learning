package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.Teacher;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
