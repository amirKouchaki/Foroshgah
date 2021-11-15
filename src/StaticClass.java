import java.util.ArrayList;

public class StaticClass {
    public static Admin admin;
    public static ArrayList<User>  suppliers = new ArrayList<>();
    public static ArrayList<User>  customers = new ArrayList<>();


    public static User findAccount(String username, int signInRole) {
        ArrayList<User> arrayListToSearch = new ArrayList<>();
        switch (signInRole){
            case 1 -> arrayListToSearch = customers;
            case 2 -> arrayListToSearch = suppliers;
            case 3 -> arrayListToSearch.add(admin);
            default -> throw new IllegalStateException("Unexpected value: " + signInRole);
        }

        for (User user :
                arrayListToSearch) {
            if(username.equalsIgnoreCase(user.getUsername()))
                return user;
        }
        return null;
    }
}
