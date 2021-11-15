import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
    private ArrayList<Product> purchases;

    public Customer(String username, String password) {
        super(username, password);
        purchases = new ArrayList<>();
        StaticClass.customers.add(this);
    }

    public static void dashboardUI(User user) {
        Customer loggedInUser = (Customer) user;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    choose item
                    1.show all purchases
                    2.purchase a product
                    0.sign out
                    """);
            int customerCommand = scanner.nextInt();
            if (customerCommand == 0)
                break;

            switch (customerCommand) {
                case 1:
                    for (int i = 0; i < loggedInUser.getPurchases().size(); i++) {
                        Product product = loggedInUser.purchases.get(i);
                        System.out.println(String.valueOf(i + 1) + '.' + product.getType() + " " + product.getPrice() + "$");
                    }
                    break;
                case 2:
                    System.out.println("choose the product you want to purchase");
                    for (int i = 0; i < StaticClass.admin.getAllProducts().size(); i++) {
                        Product product = StaticClass.admin.getAllProducts().get(i);
                        System.out.println(String.valueOf(i + 1) + '.' + product.getType() + " " + product.getPriceAfterDiscount(product) + '$');
                    }
                    int selectedProduct = scanner.nextInt() - 1;

                    loggedInUser.addPurchase(selectedProduct);
                    break;
            }

            System.out.println("enter any key to go back");
            scanner.next();
        }
    }

    private void addPurchase(int selectedProduct) {
        String response = "purchase failed.";
        Product product = StaticClass.admin.getAllProducts().get(selectedProduct);
        if(product.isAvailable()) {
            purchases.add(product);
            product.setInStock(product.getInStock() - 1);
            response = "purchase successful";
        }
        System.out.println(response);

    }

    public ArrayList<Product> getPurchases() {
        return purchases;
    }

}
