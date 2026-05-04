package model;
import java.util.ArrayList;

public class Fiera {
    private String titolo;
    private final ArrayList<Evento> eventoFiera = new ArrayList<Evento>();

    public Fiera(String titolo) {
        this.titolo = titolo;
    }

    public void setTitolo(String t) {
        this.titolo = t;
    }
    public void addEvento(Evento e) {
        eventoFiera.add(e);
    }
}
