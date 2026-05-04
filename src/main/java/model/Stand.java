package model;

import java.util.ArrayList;
import java.util.List;

public class Stand {
    private String descrizione;
    private String nome;
    private List<Lavoratore> lavoratori;
    private List<Visitatore> visitatori;

    public Stand(String descrizione, String nome) {
        this.descrizione = descrizione;
        this.nome = nome;
        this.lavoratori = new ArrayList<>();
        this.visitatori = new ArrayList<>();
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void addLavoratore(Lavoratore l) {
        lavoratori.add(l);
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void addVisitatore(Visitatore v) {
        visitatori.add(v);
    }

    public List<Visitatore> getVisitatori() {
        return visitatori;
    }
}