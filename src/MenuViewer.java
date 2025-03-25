import java.util.Scanner;

public class MenuViewer {
    public static void displayMainMenu(){

        System.out.println("\n========== Main Menu ==========");
        System.out.println("1. Login as Admin");
        System.out.println("2. Register as Admin");
        System.out.println("3. Login as Passenger");
        System.out.println("4. Register as Passenger");
        System.out.println("5. Display User Manual");
        System.out.println("0. Exit");
        System.out.print("Enter option: ") ;
    }



    public static void displayAdminMenu (String username){
        System.out.printf("\n========== Admin Menu (Logged in as \"%s\") ==========\n", username);
        System.out.println("1. Add new Passenger");
        System.out.println("2. Search a Passenger");
        System.out.println("3. Update Passenger Data");
        System.out.println("4. Delete a Passenger");
        System.out.println("5. Display all Passengers");
        System.out.println("0. Logout");
        System.out.print("Enter option: ");


    }

    public static void displayPassengerMenu( ){
        System.out.println("\n========== Passenger Menu ==========");
        System.out.println("1. Book a Flight");
        System.out.println("2. Update Your Data");
        System.out.println("3. Delete Your Account");
        System.out.println("4. Display Flight Schedule");
        System.out.println("5. Cancel a Flight");
        System.out.println("6. Display Your Registered Flights");
        System.out.println("0. Logout");
        System.out.print("Enter option: ");}

    public static void displayUserManual ( Scanner scanner)  {
        System.out.println("\n========== User Manual ==========") ;
        System.out.println("(1) Admin can manage passengers.");
        System.out.println("(2) Passengers can book flights.");
        System.out.println("Press any key to return to menu.");
        scanner.nextLine();

    }
}
