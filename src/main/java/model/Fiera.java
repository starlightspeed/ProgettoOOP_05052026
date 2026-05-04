package model;

import java.util.ArrayList;
import java.util.List;

public class Fiera {
    private final String titolo;
    private List<Padiglione> padiglioni;
    private List<Evento> eventi;

    public Fiera(String titolo) {
        this.titolo = titolo;
        this.padiglioni = new ArrayList<>();
        this.eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void addEvento(Evento e) {
        eventi.add(e);
    }

    public void addPadiglione(Padiglione p) {
        padiglioni.add(p);
    }

    public int getTotVisitatori() {
        int tot = 0;
        for (Evento evento : eventi) {
            tot += evento.getVisitatori().size();
        }
        return tot;
    }

    public List<Padiglione> getPadiglioni() {
        return padiglioni;
    }

    public List<Evento> getEventi() {
        return eventi;
    }
}