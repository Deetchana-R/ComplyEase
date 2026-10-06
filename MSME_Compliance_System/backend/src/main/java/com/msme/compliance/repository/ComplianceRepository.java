package com.msme.compliance.repository;

import com.msme.compliance.entity.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplianceRepository
        extends JpaRepository<Compliance, Long> {

    List<Compliance> findByBusinessId(Long businessId);
}