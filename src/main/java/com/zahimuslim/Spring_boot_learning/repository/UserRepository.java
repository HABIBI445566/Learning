package com.zahimuslim.Spring_boot_learning.repository;


import com.zahimuslim.Spring_boot_learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
