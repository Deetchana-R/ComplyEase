package model;

public class Business {

    private String businessName;
    private String ownerName;
    private String businessType;

    public Business(String businessName, String ownerName, String businessType) {
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.businessType = businessType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void displayBusiness() {
        System.out.println("\n===== Business Details =====");
        System.out.println("Business Name : " + businessName);
        System.out.println("Owner Name    : " + ownerName);
        System.out.println("Business Type : " + businessType);
    }
}