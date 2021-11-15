import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    private ArrayList<Supplier> suppliers;

    public Admin(String username, String password) {
        super(username, password);
        StaticClass.admin = this;
        suppliers = new ArrayList<>();
    }

    public static void dashboardUI(User user) {
        while (true) {
            Admin loggedInUser = (Admin) user;
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    choose item
                    1.show suppliers and their products
                    2.change the name of the company
                    3.offer a discount on product
                    0.sign out
                    """);
            int adminCommand = scanner.nextInt();
            if (adminCommand == 0)
                break;

            switch (adminCommand){
                case 1 :
                    for (int i = 0; i < loggedInUser.getSuppliers().size(); i++) {
                        Supplier supplier = loggedInUser.getSuppliers().get(i);
                        System.out.println(String.valueOf(i+1) + '.' + supplier.getName());
                        Product.printProducts(supplier,true,true);
                    }
                    break;
                case 2 :
                    System.out.println("choose the company that you want to change the name of");
                    Supplier.printSuppliers(loggedInUser);
                    int selectedCompany = scanner.nextInt() - 1;

                    System.out.println("enter a new name for the company");
                    String newName = scanner.nextLine();

                    loggedInUser.getSuppliers().get(selectedCompany).setName(newName);
                    break;
                case 3:
                    System.out.println("choose the product you want to offer a discount on");
                    for (int i = 0; i < loggedInUser.getAllProducts().size(); i++) {
                        Product product = loggedInUser.getAllProducts().get(i);
                        System.out.println(String.valueOf(i+1) + '.' + product.getType() + " " + product.getPriceAfterDiscount(product) + '$');
                    }
                    int selectedProduct = scanner.nextInt() - 1;

                    System.out.println("enter the discount(in percentage)");
                    int discount = scanner.nextInt();
                    loggedInUser.getAllProducts().get(selectedProduct).setDiscount(discount);
                    break;
            }

            System.out.println("enter any key to go back");
            scanner.next();
        }
    }

    ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }


    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        for (Supplier s :
                suppliers)
            allProducts.addAll(s.getProducts());
        return allProducts;
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }
}
