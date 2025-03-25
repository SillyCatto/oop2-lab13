import java.util.Scanner;

public class MenuChoiceHandler {
    private static Customer customer = new Customer();
    private static FlightReservation reservation = new FlightReservation();
    private static Flight flight = new Flight();

    public static void handleAdminMenuChoice (int option )  {
        Scanner sc = new Scanner(System.in);

        switch (option){
            case 1:
                customer.addNewCustomer();
                break;
            case 2:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Search: ");
                customer.searchUser(sc.nextLine());
                break;

            case 3:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Update: ");
                String customerID = sc.nextLine();
                if (!Customer.getCustomersCollection().isEmpty()) {
                    customer.editUserInfo(customerID);
                } else {
                    System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                }
                break;
            case 4:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Delete: ");
                customerID = sc.nextLine();
                if (!Customer.getCustomersCollection().isEmpty()) {
                    customer.editUserInfo(customerID);
                } else {
                    System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                }
                break;
            case 5:
                customer.displayCustomersData(false);
                break;
            case 0:

                System.out.println("Thanks for Using BAV Airlines Ticketing System...!!!");
                break;
            default:
                System.out.println(
                        "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");

        }


    }


    public static void handlePassengerMenuChoice (int option,  String userId) {
        Scanner sc = new Scanner(System.in);

        switch( option) {
            case 1:
                flight.displayFlightSchedule();
                System.out.print("\nEnter the desired flight number to book :\t ");
                String flightToBook = sc.nextLine();
                System.out.print("Enter the Number of tickets for " + flightToBook + " flight :   ");

                int numOfTickets = sc.nextInt();
                while (numOfTickets > 10) {
                    System.out.print(
                            "ERROR!! You can't book more than 10 tickets at a time for single flight....Enter number of tickets again : ");
                    numOfTickets = sc.nextInt();
                }

                sc.nextLine();
                reservation.bookFlight(flightToBook, numOfTickets, userId);
                break;
            case 2:
                customer.editUserInfo(userId);
                break;
            case 3:

                System.out.print(
                        "Are you sure to delete your account...It's an irreversible action...Enter Y/y to confirm...");
                char confirmationChar = sc.nextLine().charAt(0);
                if (confirmationChar == 'Y' || confirmationChar == 'y') {
                    customer.deleteUser(userId);
                    System.out.printf("User %s's account deleted Successfully...!!!", userId);
                } else {
                    System.out.println("Action has been cancelled...");
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
                System.out.println(
                        "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");
        }
    }


}
