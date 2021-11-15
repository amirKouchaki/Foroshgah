import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Supplier> suppliers;

    public Admin(String username, String password) {
        super(username, password);
        StaticClass.admins.add(this);
    }

    public static void dashboardUI(User loggedInUser) {
    }


    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        for (Supplier s :
                suppliers)
            allProducts.addAll(s.getProducts());
        return allProducts;
    }

}
