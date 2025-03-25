import java.util.Scanner;

public class MenuChoiceHandler {
    private static Customer customer = new Customer();
    private static FlightReservation reservation = new FlightReservation();
    private static Flight flight = new Flight();

    public static void handleAdminMenuChoice (int option,Scanner scanner )  {
        switch (option){
            case 1:
                customer.addNewCustomer();
                break;
            case 2:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Search: ");
                customer.searchUser(scanner.nextLine());
                break;

            case 3:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Update: ");
                customer.editUserInfo(scanner.nextLine());
                break;
            case 4:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Delete: ");
                customer.deleteUser(scanner.nextLine());
                break;
            case 5:
                customer.displayCustomersData(false);
                break;
            case 0:

                System.out.println("Logging out..." );
                break;
            default:
                System.out.println("Invalid choice.");

        }


    }


    public static void handlePassengerMenuChoice (int option, Scanner scanner,String userId) {
        switch( option) {
            case 1:
                flight.displayFlightSchedule();
                System.out.print("\nEnter Flight Number to Book: ");
                String flightToBook = scanner.nextLine();
                System.out.print("Enter Number of Tickets: ");
                int numOfTickets = scanner.nextInt();
                scanner.nextLine();
                reservation.bookFlight(flightToBook, numOfTickets, userId);
                break;
            case 2:
                customer.editUserInfo(userId);
                break;
            case 3:
                System.out.print("Confirm account deletion (Y/N): ");
                char confirmation = scanner.nextLine().charAt(0);
                if (confirmation == 'Y' || confirmation == 'y') {
                    customer.deleteUser(userId);
                    System.out.println("Account deleted successfully.");
                }
                break;
            case 4:
                flight.displayFlightSchedule();
                break;
            case 5:
                reservation.cancelFlight(userId);
                break;
            case 6:
                reservation.displayFlightsRegisteredByOneUser(userId);
                break;
            case 0:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }


}
