import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("" +
                "1.Sign Up\n" +
                "2.Sign In\n" +
                "0.exit");
        int authorizationAction = scanner.nextInt();
        switch (authorizationAction) {
            case 1 -> signUp();
            case 2 -> signIn();
            default -> System.exit(0);
        }
    }

    private static void signIn() {

    }

    private static void signUp() {
    }
}

enum Type {
    REFRIGERATOR, AIR_CONDITIONER, TV
}

