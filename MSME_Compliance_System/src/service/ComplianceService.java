package service;

import java.util.ArrayList;
import model.Compliance;

public class ComplianceService {

    private ArrayList<Compliance> complianceList = new ArrayList<>();

    // Add Compliance
    public void addCompliance(Compliance compliance) {
        complianceList.add(compliance);
        System.out.println("\nCompliance added successfully!");
    }

    // View Compliance
    public void viewCompliance() {

        if (complianceList.isEmpty()) {
            System.out.println("\nNo compliance records found.");
            return;
        }

        System.out.println("\n===== Compliance Records =====");

        for (Compliance c : complianceList) {
            c.displayCompliance();
        }
    }
}