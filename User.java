package delfinen;

public class User {
    private String username;
    private String password;
    private String clearance;

    public User(String username, String password, String clearance){
        this.username = username;
        this.password = password;
        this.clearance = clearance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClearance() {
        return clearance;
    }
}