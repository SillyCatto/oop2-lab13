/*
 * This class is intended to be the main class for this Project. All necessary methods are getting calls from this class.
 *
 *
 */

import java.util.List;
import java.util.Scanner;

public class User {

    // ************************************************************ Fields
    // ************************************************************

    /*
     * 2D Array to store admin credentials. Default credentials are stored on [0][0]
     * index. Max num of admins can be 10....
     */
    static String[][] adminCredentials = new String[10][2];

    // ************************************************************
    // Behaviours/Methods
    // ************************************************************
    private static void setDefaultAdminCredentials() {
        adminCredentials[0][0] = "root";
        adminCredentials[0][1] = "root";
    }

    private static void startApplication( ){
        Scanner scanner = new Scanner(System.in);
        RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();
        Flight flight = new Flight();
        FlightReservation reservation = new FlightReservation();
        Customer customer = new Customer();
        LoginHandler loginHandler = new LoginHandler(rolesAndPermissions, reservation, flight, customer, adminCredentials);

        int option;
        do{
            MenuViewer.displayMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            handleMainMenuSelection(option, scanner, loginHandler, customer);

        }while(option != 0);
    }


    private static void handleMainMenuSelection (int option, Scanner scanner,LoginHandler loginHandler,Customer customer) {
        switch (option) {
            case 1:
                loginHandler.handleAdminLogin();
                break;

            case 2:

                RegistrationHandler.registerAdmin();
                break;
            case 3:
                loginHandler.handlePassengerLogin(scanner);
                break;
            case 4:
                customer.addNewCustomer();
                break;
            case 5:
                MenuViewer.displayUserManual( );
                break;
            default:

                System.out.println("Invalid option. Please enter a value between 0 - 5.");


        }
    }

    public static void main(String[] args) {
        setDefaultAdminCredentials();
        startApplication();
    }






}