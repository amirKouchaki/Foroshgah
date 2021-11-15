public class Product {
    private long price;
    private int size;
    private int power;
    private int volume;
    private String companyName;
    private Type type;
    private int inStock;


    public Product(long price,int size,int power,int volume,String companyName,Type type,int inStock) {
        this.price = price;
        this.size = size;
        this.power = power;
        this.volume = volume;
        this.companyName = companyName;
        this.type = type;
        this.inStock = inStock;
    }

    public Type getType() {
        return type;
    }

    public boolean isAvailable(){
        return inStock > 0;
    }

    public long getPrice(){
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public static void printProducts(Supplier loggedInUser,boolean printPrice,boolean printTab){
        for (int i = 0; i < loggedInUser.getProducts().size(); i++){
            Product product = loggedInUser.getProducts().get(i);
            System.out.print(printTab?'\t':"");
            System.out.println(String.valueOf(i+1) + '.' + product.getType() + " " +(!printPrice? "":product.getPrice() + "$"));
        }

    }
}
