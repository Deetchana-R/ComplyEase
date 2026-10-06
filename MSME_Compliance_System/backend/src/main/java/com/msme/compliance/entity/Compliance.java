package com.msme.compliance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compliances")
public class Compliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complianceName;

    private LocalDate dueDate;

    private String frequency;

    private String status;

    private Double penaltyAmount;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    public Compliance() {
    }

    public Compliance(String complianceName,
                      LocalDate dueDate,
                      String frequency,
                      String status,
                      Double penaltyAmount,
                      Business business) {

        this.complianceName = complianceName;
        this.dueDate = dueDate;
        this.frequency = frequency;
        this.status = status;
        this.penaltyAmount = penaltyAmount;
        this.business = business;
    }

    public Long getId() {
        return id;
    }

    public String getComplianceName() {
        return complianceName;
    }

    public void setComplianceName(String complianceName) {
        this.complianceName = complianceName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}