import java.util.Scanner;

import model.Business;
import model.Compliance;
import service.ComplianceService;
import menu.Menu;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ComplianceService service = new ComplianceService();
        Business business = null;

        int choice;

        do {

            Menu.showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Business Name: ");
                    String bName = sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    System.out.print("Enter Business Type: ");
                    String type = sc.nextLine();

                    business = new Business(bName, owner, type);

                    System.out.println("\nBusiness Registered Successfully!");
                    business.displayBusiness();

                    break;

                case 2:

                    System.out.print("Enter Compliance Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    String due = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    Compliance compliance = new Compliance(cname, due, status);

                    service.addCompliance(compliance);

                    break;

                case 3:

                    service.viewCompliance();

                    break;

                case 4:

                    System.out.println("\nThank you!");
                    break;

                default:

                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 4);

        sc.close();
    }
}