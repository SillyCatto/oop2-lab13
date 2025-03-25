import java.util.Scanner;

public class RegistrationHandler {
    public static void registerAdmin( ) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username to Register: ") ;
        String username = sc.nextLine();
        System.out.print("Enter Password to Register: ");
        String password = sc.nextLine();

        RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();
        if (rolesAndPermissions.isPrivilegedUserOrNot(username, password) != -1) {
            System.out.println("Error Admin with same username already exists");
        } else {
            User.adminCredentials[1][0] = username;
            User.adminCredentials[1][1] = password;
            System.out.println("Admin registered successfully");
        }
    }
}
