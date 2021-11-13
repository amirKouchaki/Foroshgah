import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Supplier> suppliers;


    public ArrayList<Merchandise> getAllMerchandises() {
        ArrayList<Merchandise> allMerchandises = new ArrayList<>();
        for (Supplier s :
                suppliers)
            allMerchandises.addAll(s.getMerchandises());
        return allMerchandises;
    }

}
