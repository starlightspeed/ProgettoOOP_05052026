package model;

public class Visitatore extends Utente {
    private Biglietto biglietto;

    public Visitatore(String login, String password) {
        super(login, password);
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }
}