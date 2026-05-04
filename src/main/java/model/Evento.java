public class Evento {
    private String titolo;
    private String descrizione;
    private int maxCapienza;

    private Ospite[] ospiti;
    private int ospitiCount;

    public Evento(String titolo, String descrizione, int maxCapienza) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.maxCapienza = maxCapienza;


        this.ospiti = new Ospite[maxCapienza];
        this.ospitiCount = 0;
    }

    public void addOspite(Ospite ospite) {
        if (!isCapienzaFull()) {
            ospiti[ospitiCount] = ospite;
            ospitiCount++;
        } else {
            System.out.println("Errore: Capienza massima raggiunta per l'evento " + titolo);
        }
    }

    public boolean isCapienzaFull() {
        return ospitiCount >= maxCapienza;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }
}