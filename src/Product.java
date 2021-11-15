public class Product {
    private long price;
    private int size;
    private int power;
    private int volume;
    private String companyName;
    private Type type;
    private int inStock;
    private int discount;

    public Product(long price, int size, int power, int volume, String companyName, Type type, int inStock) {
        this.price = price;
        this.size = size;
        this.power = power;
        this.volume = volume;
        this.companyName = companyName;
        this.type = type;
        this.inStock = inStock;
        this.discount = 0;
    }

    public Type getType() {
        return type;
    }

    public boolean isAvailable() {
        return inStock > 0;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public static void printProducts(Supplier loggedInUser, boolean printPrice, boolean printTab) {
        for (int i = 0; i < loggedInUser.getProducts().size(); i++) {
            Product product = loggedInUser.getProducts().get(i);
            System.out.print(printTab ? '\t' : "");
            System.out.println(String.valueOf(i + 1) + '.' + product.getType() + " " + (!printPrice ? "" : product.getPriceAfterDiscount(product) + "$"));
        }

    }

    public long getPriceAfterDiscount(Product product) {
        if (product.getDiscount() > 0 && product.getDiscount() < 100)
            return product.getPrice() - (product.getPrice() * product.getDiscount() / 100);

        return product.getPrice();
    }

    private  int getDiscount() {
        return discount;
    }

    public void setCompanyName(String name) {
        this.companyName = name;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getInStock(){
        return inStock;
    }


    public void setInStock(int inStock){
        this.inStock = inStock;
    }
}
