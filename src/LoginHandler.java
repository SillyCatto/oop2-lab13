import java.util.Scanner;

public class LoginHandler {
    private RolesAndPermissions rolesAndPermissions;
    private FlightReservation reservation;
    private Flight flight;
    private Customer customer;
    private String[][] adminCredentials;

    public LoginHandler(RolesAndPermissions rolesAndPermissions,FlightReservation reservation, Flight flight, Customer customer, String[][] adminCredentials) {

        this.rolesAndPermissions = rolesAndPermissions;
        this.reservation = reservation;
        this.flight = flight;
        this.customer = customer;
        this.adminCredentials = adminCredentials;
    }


    public void handleAdminLogin(Scanner scanner){

        System.out.print("\nEnter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        int privilegeLevel = rolesAndPermissions.isPrivilegedUserOrNot(username, password);
        if (privilegeLevel == -1) {
            System.out.println("ERROR! Unable to login. User not found.");
        } else if (privilegeLevel == 0) {
            System.out.println("You have standard access. You can only view customer data.");
            customer.displayCustomersData(true);
        } else
        {
            MenuViewer.displayAdminMenu(scanner, username);
        }

    }

    public void handlePassengerLogin  (Scanner scanner) {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        String[] result = rolesAndPermissions.isPassengerRegistered(email, password).split("-");

        if (Integer.parseInt(result[0]) == 1){
            MenuViewer.displayPassengerMenu(scanner,result[1] );
        }else {
            System.out.println("ERROR! Unable to login. User not found.");
        }
    }


}
