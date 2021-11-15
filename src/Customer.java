import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Product> purchases;

    public Customer(String username,String password) {
        super(username,password);
        purchases = new ArrayList<>();
        StaticClass.customers.add(this);
    }

    public static void dashboardUI(User loggedInUser) {
    }
}
