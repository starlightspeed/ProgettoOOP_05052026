package model;

import java.util.ArrayList;

public class Eventi {
    private String titolo;
    private String descrizione;
    private int maxCapienza;

    private final ArrayList<Ospite> ospiti = new ArrayList<>();
    private final ArrayList<Visitatore> visitatori = new ArrayList<>();

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public int getMaxCapienza() { return maxCapienza; }
    public void setMaxCapienza(int maxCapienza) { this.maxCapienza = maxCapienza; }


    public int getNumeroOspiti() {
        return ospiti.size();
    }

    public int getNumeroVisitatori() {
        return visitatori.size();
    }


    public void addOspite(Ospite o) {
        if (!isCapienzaFull()) {
            ospiti.add(o);
            System.out.println("Guest added successfully.");
        } else {
            System.out.println("Error! Max capacity reached.");
        }
    }

    public void addVisitatore(Visitatore v) {
        if (!isCapienzaFull()) {
            visitatori.add(v);
            System.out.println("Visitor added successfully.");
        } else {
            System.out.println("Error! Max capacity reached.");
        }
    }

    public boolean isCapienzaFull() {
        int totalPeople = ospiti.size() + visitatori.size();
        return totalPeople >= maxCapienza;
    }
}