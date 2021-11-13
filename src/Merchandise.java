public class Merchandise {
    private long price;
    private int size;
    private int power;
    private int volume;
    private Type type;
    private int inStock;


    public Merchandise(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean isAvailable(){
        return inStock > 0;
    }

}
