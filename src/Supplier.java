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

    public static void dashboardUI(User user) {
        Supplier loggedInUser = (Supplier) user;
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
                case 1 :
                    Product.printProducts(loggedInUser,true,false);
                    break;
                case 2 :
                    System.out.println("choose the product you wish to change the price of");
                    Product.printProducts(loggedInUser,true,false);
                    int selectedProduct = scanner.nextInt() - 1;

                    System.out.println("enter a new price for the selected product");
                    long newPrice = scanner.nextLong();

                    loggedInUser.getProducts().get(selectedProduct).setPrice(newPrice);
                    break;
                case 3 :
                    System.out.println("enter the price of your new product.");
                    long price = scanner.nextLong();

                    System.out.println("enter the size of your new product.");
                    int size = scanner.nextInt();

                    System.out.println("enter the power of your new product.");
                    int power = scanner.nextInt();

                    System.out.println("enter the volume of your new product.");
                    int volume = scanner.nextInt();

                    System.out.println("""
                            enter the type of your product
                            1.Refrigerator
                            2.TV
                            3.Air Conditioner
                            """);
                    int chosenType = scanner.nextInt();
                    Type type;
                    switch (chosenType){
                        case 1 -> type = Type.REFRIGERATOR;
                        case 2 -> type = Type.TV;
                        case 3 -> type = Type.AIR_CONDITIONER;
                        default -> type = null;
                    }

                    System.out.println("enter how many of this product you have in stock.");
                    int inStock = scanner.nextInt();

                    loggedInUser.addProduct(price,size,power,volume,type,inStock);
                    break;
                case 4 :
                    System.out.println("choose the product you wish remove");
                    Product.printProducts(loggedInUser,true,false);
                    selectedProduct = scanner.nextInt() - 1;
                    loggedInUser.getProducts().remove(selectedProduct);
                    break;
            }

            System.out.println("enter any key to go back");
            scanner.next();
        }

    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(long price,int size,int power,int volume,Type type,int inStock){
        products.add(new Product(price,size,power,volume,this.name,type,inStock));
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
        for (Product product:
             products) {
            product.setCompanyName(name);
        }
    }

    public static void printSuppliers(Admin loggedInUser){
        for (int i = 0; i < loggedInUser.getSuppliers().size(); i++) {
            System.out.println((i+1) + '.' + loggedInUser.getSuppliers().get(i).getName());
        }
    }
}
//TODO: username should be unique