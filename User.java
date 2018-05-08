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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClearance() {
        return clearance;
    }

    public void setClearance(String clearance) {
        this.clearance = clearance;
    }
}
