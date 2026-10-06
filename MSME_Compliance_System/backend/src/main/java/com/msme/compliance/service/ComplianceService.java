package com.msme.compliance.service;

import com.msme.compliance.entity.Compliance;
import com.msme.compliance.repository.ComplianceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceService {

    private final ComplianceRepository complianceRepository;

    public ComplianceService(ComplianceRepository complianceRepository) {
        this.complianceRepository = complianceRepository;
    }

    public Compliance saveCompliance(Compliance compliance) {
        return complianceRepository.save(compliance);
    }

    public List<Compliance> getAllCompliances() {
        return complianceRepository.findAll();
    }

    public Compliance getComplianceById(Long id) {
        return complianceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Compliance not found"));
    }

    public List<Compliance> getCompliancesByBusiness(Long businessId) {
        return complianceRepository.findByBusinessId(businessId);
    }

    public void deleteCompliance(Long id) {
        complianceRepository.deleteById(id);
    }
    public void deleteCompliance(Long id) {
    complianceRepository.deleteById(id);
}

public double calculatePenalty(Long id) {

    Compliance compliance = getComplianceById(id);

    if ("Completed".equalsIgnoreCase(compliance.getStatus())) {
        return 0;
    }

    if (compliance.getDueDate().isBefore(java.time.LocalDate.now())) {

        long lateDays =
                java.time.temporal.ChronoUnit.DAYS.between(
                        compliance.getDueDate(),
                        java.time.LocalDate.now()
                );

        return lateDays * compliance.getPenaltyAmount();
    }

    return 0;
}
}