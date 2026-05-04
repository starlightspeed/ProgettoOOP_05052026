package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Fiera {
    private final String titolo;
    private final ArrayList<Eventi> eventiFiera = new ArrayList<Eventi>();

    public Fiera(String titolo) {
        this.titolo = titolo;
    }

    public static Fiera setTitolo() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Title of the Fiera: ");
        String titolo = input.next();

        return new Fiera(titolo);
    }


    public void addEvento(Eventi e) {
        eventiFiera.add(e);
    }
}
