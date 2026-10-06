package com.msme.compliance.controller;

import com.msme.compliance.entity.Compliance;
import com.msme.compliance.service.ComplianceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliances")
@CrossOrigin(origins = "*")
public class ComplianceController {

    private final ComplianceService complianceService;

    public ComplianceController(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    @PostMapping
    public Compliance createCompliance(
            @RequestBody Compliance compliance) {

        return complianceService.saveCompliance(compliance);
    }

    @GetMapping
    public List<Compliance> getAllCompliances() {

        return complianceService.getAllCompliances();
    }

    @GetMapping("/{id}")
    public Compliance getCompliance(
            @PathVariable Long id) {

        return complianceService.getComplianceById(id);
    }

    @GetMapping("/business/{businessId}")
    public List<Compliance> getCompliancesByBusiness(
            @PathVariable Long businessId) {

        return complianceService
                .getCompliancesByBusiness(businessId);
    }
@PutMapping("/{id}/complete")
public Compliance markCompleted(
        @PathVariable Long id) {

    Compliance compliance =
            complianceService.getComplianceById(id);

    compliance.setStatus("Completed");

    return complianceService.saveCompliance(compliance);
}
    @DeleteMapping("/{id}")
    public void deleteCompliance(
            @PathVariable Long id) {

        complianceService.deleteCompliance(id);
    }
    @GetMapping("/{id}/penalty")
public double calculatePenalty(@PathVariable Long id) {
    return complianceService.calculatePenalty(id);
}
}