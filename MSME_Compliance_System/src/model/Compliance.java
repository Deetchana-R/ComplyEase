package model;

public class Compliance {

    private String complianceName;
    private String dueDate;
    private String status;

    public Compliance(String complianceName, String dueDate, String status) {
        this.complianceName = complianceName;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getComplianceName() {
        return complianceName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void displayCompliance() {
        System.out.println("\n----- Compliance Details -----");
        System.out.println("Compliance : " + complianceName);
        System.out.println("Due Date   : " + dueDate);
        System.out.println("Status     : " + status);
    }
}