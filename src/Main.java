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




        Supplier supplier = new Supplier("sadra","ali", "tarash");
        supplier.addProduct(2000,2,20,400,Type.AIR_CONDITIONER,200);
        supplier.addProduct(195,10,300,42,Type.REFRIGERATOR,1500);
        supplier.addProduct(4153,52,98,71,Type.TV,100);
        supplier.addProduct(2,200,41,90,Type.REFRIGERATOR,555);
        supplier.addProduct(5102351,6,205,500000,Type.AIR_CONDITIONER,321);

        Supplier secondSupplier = new Supplier("ahmad","mohammad", "123");
        secondSupplier.addProduct(2514,2,20,400,Type.AIR_CONDITIONER,200);
        secondSupplier.addProduct(12,10,300,42,Type.REFRIGERATOR,1500);
        secondSupplier.addProduct(514,52,98,71,Type.TV,100);
        secondSupplier.addProduct(6141516,200,41,90,Type.REFRIGERATOR,555);
        secondSupplier.addProduct(342,6,205,500000,Type.AIR_CONDITIONER,321);




        Admin admin = new Admin("mehran", "mahi");
        admin.addSupplier(supplier);
        admin.addSupplier(secondSupplier);

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

