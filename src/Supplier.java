import java.util.ArrayList;

public class Supplier extends User {
    private String name;
    private ArrayList<Merchandise> merchandises;

    public Supplier() {
        merchandises = new ArrayList<>();
    }

    public ArrayList<Merchandise> getMerchandises() {
        return merchandises;
    }
}
