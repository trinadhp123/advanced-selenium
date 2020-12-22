package test.java.data;

public class User {
    private String userName;
    private String password;

    public static User valid() {
        User user = new User();
        user.userName = "standard_user";
        user.password = "secret_sauce";
        return user;
    }

    public static User invalid() {
        User user = new User();
        user.userName = "locked_out_user";
        user.password = "secret_sauce";
        return user;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
