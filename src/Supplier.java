import java.util.ArrayList;
import java.util.Scanner;

public class Supplier extends User {
    private String name;
    private ArrayList<Product> products;

    public Supplier(String name,String username, String password) {
        super(username,password);
        this.name = name;
        StaticClass.suppliers.add(this);
        products = new ArrayList<>();
    }

    public static void dashboardUI(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("""
                    choose item
                    1.products list
                    2.change the price of a product
                    3.add a product
                    4.remove a product
                    0.sign out
                    """);
            int supplierCommand = scanner.nextInt();
            if(supplierCommand == 0)
                break;

            switch (supplierCommand){
                case 1 -> printProducts((Supplier) loggedInUser,true);
            }
        }

    }

    public static void printProducts(Supplier loggedInUser,boolean printPrice){
        for (Product product :
                loggedInUser.getProducts()) {
            System.out.println(!printPrice
                    ?product.getType()
                    :product.getType() + " " + product.getPrice() + "$");
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
