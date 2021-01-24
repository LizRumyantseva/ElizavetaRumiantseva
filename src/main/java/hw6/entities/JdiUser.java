package hw6.entities;

public class JdiUser {
    public static final JdiUser ROMAN = new JdiUser("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String login;
    private final String password;
    private final String userName;

    public JdiUser(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
