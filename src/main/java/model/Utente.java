package model;
import java.util.Scanner;

/**
 * The type Utente.
 */
public class Utente {
    private final String login;
    private String password;

    /**
     * Register part for the account:
     *
     */

    public static Utente Register() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String login = input.next();

        System.out.println("Enter your password: ");
        String password = input.next();

        return new Utente(login, password);
    }

    /**
     * Instantiates a new Utente.
     *
     * @param login    the login
     * @param password the password
     */
    public Utente(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    //ur dumass forgot the password, so u reset it to the new password
    public void setPassword(String newPassword) {
        this.password = newPassword;

        System.out.println("\n\n\n\n\n\n\n\n\nPassword has been changed. ");
    }


}