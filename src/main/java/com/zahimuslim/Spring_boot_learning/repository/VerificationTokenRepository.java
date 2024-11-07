package com.zahimuslim.Spring_boot_learning.repository;

import com.zahimuslim.Spring_boot_learning.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
}
