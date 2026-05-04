package model;

public class Lavoratore extends Utente {
    private Mansione mansione;

    public Lavoratore(String login, String password) {
        super(login, password);
    }

    public void setMansione(Mansione mansione) {
        this.mansione = mansione;
    }

    public Mansione getMansione() {
        return mansione;
    }
}