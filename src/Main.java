import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        while (true) {
            System.out.println("""
                    1.Sign Up
                    2.Sign In
                    0.exit""");
            int authorizationAction = scanner.nextInt();
            switch (authorizationAction) {
                case 1 -> signUpUI();
                case 2 -> signInUI();
                default -> System.exit(0);
            }
        }
    }

    private static void init() {
        new Customer("amir", "1234");
        new Customer("nima", "Nama");
        new Supplier("sadra","ali", "tarash");
        new Admin("mehran", "mahi");
    }

    private static void signInUI() {
        while (true) {
            System.out.println("""
                    choose your role\s
                    1.Customer
                    2.Supplier
                    3.Admin
                    0.go back""");
            int signInRole = scanner.nextInt();
            if (signInRole == 0)
                break;

            System.out.println("please enter your username.");
            String username = scanner.next();
            System.out.println("please enter your password.");
            String password = scanner.next();
            User loggedInUser = User.signIn(username, password, signInRole);
            if (loggedInUser == null) {
                System.out.println("entered username or password was invalid.");
                scanner.next();
            } else
                dashboardUI(loggedInUser,signInRole);
        }
    }

    private static void dashboardUI(User loggedInUser, int signInRole) {
        switch (signInRole){
            case 1 -> Customer.dashboardUI(loggedInUser);
            case 2 -> Supplier.dashboardUI(loggedInUser);
            case 3 -> Admin.dashboardUI(loggedInUser);
        }
    }

    private static void signUpUI() {
        while (true) {
            System.out.println("""
                    sign up as
                    1.Customer
                    2.Supplier
                    3.Admin
                    0.go back""");
            int signInRole = scanner.nextInt();
            if (signInRole == 0)
                break;
            String name = "";
            if(signInRole == 2) {
                System.out.println("please enter your name");
                name = scanner.next();
            }

            System.out.println("please enter your username");
            String username = scanner.next();
            System.out.println("please enter your password");
            String password = scanner.next();

            User.signUp(name,username,password,signInRole);

            System.out.println("enter any key to go back");
            scanner.next();
        }
    }
}

enum Type {
    REFRIGERATOR, AIR_CONDITIONER, TV
}

