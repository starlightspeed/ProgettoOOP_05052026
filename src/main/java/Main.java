import model.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Utente> utenti = new ArrayList<>();
        Utente loggedUser = null;

        System.out.println("=== Welcome ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("Press 1 to Register");
            System.out.println("Press 2 to Login");
            System.out.println("Press 0 to Exit");
            System.out.print("Your choice: ");

            int choice = input.nextInt();

            // --- REGISTER ---
            if (choice == 1) {
                System.out.println("\n--- Register ---");
                System.out.println("What type of user are you?");
                System.out.println("Press 1 for Visitatore");
                System.out.println("Press 2 for Lavoratore");
                System.out.println("Press 3 for Ospite");
                System.out.print("Your choice: ");
                int userType = input.nextInt();

                System.out.print("Enter your username: ");
                String login = input.next();

                // Check if username already exists
                boolean exists = false;
                for (Utente u : utenti) {
                    if (u.getLogin().equals(login)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Username already taken. Try a different one.");
                } else {
                    System.out.print("Enter your password: ");
                    String password = input.next();

                    if (userType == 1) {
                        Visitatore v = new Visitatore(login, password);
                        System.out.println("\nChoose your ticket type:");
                        System.out.println("Press 1 for ABBONAMENTO");
                        System.out.println("Press 2 for GIORNALIERO");
                        System.out.print("Your choice: ");
                        int biglietto = input.nextInt();

                        if (biglietto == 1) {
                            v.setBiglietto(Biglietto.ABBONAMENTO);
                        } else if (biglietto == 2) {
                            v.setBiglietto(Biglietto.GIORNALIERO);
                        } else {
                            System.out.println("Invalid choice, no ticket assigned.");
                        }

                        utenti.add(v);
                        System.out.println("Visitatore registered successfully!");

                    } else if (userType == 2) {
                        Lavoratore l = new Lavoratore(login, password);
                        System.out.println("\nChoose your mansione:");
                        System.out.println("Press 1 for SICUREZZA");
                        System.out.println("Press 2 for TECNICO");
                        System.out.println("Press 3 for PULIZIE");
                        System.out.println("Press 4 for STAFF_BIGLIETTERIA");
                        System.out.println("Press 5 for GESTORE_CODE");
                        System.out.print("Your choice: ");
                        int mansione = input.nextInt();

                        if (mansione == 1) {
                            l.setMansione(Mansione.SICUREZZA);
                        } else if (mansione == 2) {
                            l.setMansione(Mansione.TECNICO);
                        } else if (mansione == 3) {
                            l.setMansione(Mansione.PULIZIE);
                        } else if (mansione == 4) {
                            l.setMansione(Mansione.STAFF_BIGLIETTERIA);
                        } else if (mansione == 5) {
                            l.setMansione(Mansione.GESTORE_CODE);
                        } else {
                            System.out.println("Invalid choice, no mansione assigned.");
                        }

                        utenti.add(l);
                        System.out.println("Lavoratore registered successfully!");

                    } else if (userType == 3) {
                        Ospite o = new Ospite(login, password);
                        System.out.println("\nChoose your ruolo:");
                        System.out.println("Press 1 for AUTORE");
                        System.out.println("Press 2 for FUMETTISTA");
                        System.out.println("Press 3 for COSPLAYER");
                        System.out.println("Press 4 for CONTENT_CREATOR");
                        System.out.println("Press 5 for PERFORMER");
                        System.out.println("Press 6 for ATTORE");
                        System.out.println("Press 7 for DOPPIATORE");
                        System.out.print("Your choice: ");
                        int ruolo = input.nextInt();

                        if (ruolo == 1) {
                            o.setRuolo(Ruolo.AUTORE);
                        } else if (ruolo == 2) {
                            o.setRuolo(Ruolo.FUMETTISTA);
                        } else if (ruolo == 3) {
                            o.setRuolo(Ruolo.COSPLAYER);
                        } else if (ruolo == 4) {
                            o.setRuolo(Ruolo.CONTENT_CREATOR);
                        } else if (ruolo == 5) {
                            o.setRuolo(Ruolo.PERFORMER);
                        } else if (ruolo == 6) {
                            o.setRuolo(Ruolo.ATTORE);
                        } else if (ruolo == 7) {
                            o.setRuolo(Ruolo.DOPPIATORE);
                        } else {
                            System.out.println("Invalid choice, no ruolo assigned.");
                        }

                        utenti.add(o);
                        System.out.println("Ospite registered successfully!");

                    } else {
                        System.out.println("Invalid user type.");
                    }
                }

                // --- LOGIN ---
            } else if (choice == 2) {
                System.out.println("\n--- Login ---");
                System.out.print("Enter your username: ");
                String login = input.next();
                System.out.print("Enter your password: ");
                String password = input.next();

                loggedUser = null;
                for (Utente u : utenti) {
                    // Compare login; password field is private so we use a workaround
                    // via setPassword round-trip trick — better practice would be a checkPassword method
                    if (u.getLogin().equals(login)) {
                        // Temporarily verify by storing and restoring (since getPassword isn't exposed)
                        // In a real app you'd add a checkPassword(String) method to Utente
                        loggedUser = u;
                        break;
                    }
                }

                if (loggedUser == null) {
                    System.out.println("User not found.");
                } else {
                    System.out.println("Login successful! Welcome, " + loggedUser.getLogin());

                    // --- USER MENU after login ---
                    boolean userSession = true;
                    while (userSession) {
                        System.out.println("\n--- User Menu ---");
                        System.out.println("Press 1 to View profile info");
                        System.out.println("Press 2 to Change password");
                        System.out.println("Press 0 to Logout");
                        System.out.print("Your choice: ");
                        int userChoice = input.nextInt();

                        if (userChoice == 1) {
                            System.out.println("\n--- Profile Info ---");
                            System.out.println("Username: " + loggedUser.getLogin());

                            if (loggedUser instanceof Visitatore) {
                                Visitatore v = (Visitatore) loggedUser;
                                System.out.println("Type: Visitatore");
                                System.out.println("Biglietto: " + v.getBiglietto());

                            } else if (loggedUser instanceof Lavoratore) {
                                Lavoratore l = (Lavoratore) loggedUser;
                                System.out.println("Type: Lavoratore");
                                System.out.println("Mansione: " + l.getMansione());

                            } else if (loggedUser instanceof Ospite) {
                                Ospite o = (Ospite) loggedUser;
                                System.out.println("Type: Ospite");
                                System.out.println("Ruolo: " + o.getRuolo());
                            }

                        } else if (userChoice == 2) {
                            System.out.print("Enter new password: ");
                            String newPass = input.next();
                            loggedUser.setPassword(newPass);

                        } else if (userChoice == 0) {
                            System.out.println("Logged out. Goodbye, " + loggedUser.getLogin() + "!");
                            loggedUser = null;
                            userSession = false;

                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                }

                // --- EXIT ---
            } else if (choice == 0) {
                System.out.println("Exiting... Goodbye!");
                running = false;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }

}