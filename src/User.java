public class User {
    private String username;
    private String password;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    /**
     *
     * @param username
     * @param password
     * @param signInRole 1->Customer,2->Supplier,3->Admin
     */
    public static User signIn(String username, String password, int signInRole) {
        User user = StaticClass.findAccount(username,signInRole);
        if (user == null)
            return null;
        return password.equals(user.getPassword())? user : null;
    }

    public static void signUp(String name, String username, String password, int signInRole) {
        switch (signInRole){
            case 1 -> new Customer(username,password);
            case 2 -> new Supplier(name,username,password);
            case 3 -> new Admin(username,password);
            default -> throw new IllegalStateException("Unexpected value: " + signInRole);
        }
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
