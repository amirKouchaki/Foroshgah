public class Product {
    private long price;
    private int size;
    private int power;
    private int volume;
    private String companyName;
    private Type type;
    private int inStock;


    public Product(Type type) {
        this.type = type;
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
}
