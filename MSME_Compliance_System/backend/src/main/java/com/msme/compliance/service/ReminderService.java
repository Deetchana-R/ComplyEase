package com.msme.compliance.service;

import com.msme.compliance.entity.Compliance;
import com.msme.compliance.repository.ComplianceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReminderService {

    private final ComplianceRepository complianceRepository;

    public ReminderService(ComplianceRepository complianceRepository) {
        this.complianceRepository = complianceRepository;
    }

    public List<String> getReminders() {

        List<Compliance> compliances =
                complianceRepository.findAll();

        List<String> reminders = new ArrayList<>();

        LocalDate today = LocalDate.now();

        for (Compliance compliance : compliances) {

            if ("Completed".equalsIgnoreCase(compliance.getStatus())) {
                continue;
            }

            LocalDate dueDate = compliance.getDueDate();

            if (dueDate.isBefore(today)) {

                reminders.add(
                    "OVERDUE: " +
                    compliance.getComplianceName()
                );

            } else if (!dueDate.isAfter(today.plusDays(7))) {

                reminders.add(
                    "DUE SOON: " +
                    compliance.getComplianceName()
                );
            }
        }

        return reminders;
    }
}