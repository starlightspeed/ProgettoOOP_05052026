package model;

public class Ospite extends Utente {
    private Ruolo ruolo;

    public Ospite(String login, String password) {
        super(login, password);
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}