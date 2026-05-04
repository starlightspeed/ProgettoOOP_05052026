package model;

import java.util.ArrayList;
import java.util.List;

public class Padiglione {
    private String padiglione_ID;
    private String nome;
    private List<Stand> stands;
    private List<Evento> eventi;

    public Padiglione(String padiglione_ID, String nome) {
        this.padiglione_ID = padiglione_ID;
        this.nome = nome;
        this.stands = new ArrayList<>();
        this.eventi = new ArrayList<>();
    }

    public String getPadiglione_ID() {
        return padiglione_ID;
    }

    public String getNome() {
        return nome;
    }

    public void addStand(Stand s) {
        stands.add(s);
    }

    public List<Stand> getStands() {
        return stands;
    }

    public void addEvento(Evento e) {
        eventi.add(e);
    }

    public List<Evento> getEventi() {
        return eventi;
    }
}