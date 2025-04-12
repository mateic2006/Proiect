import java.util.List;
import java.util.ArrayList;

public class Utilizator {
    private String nume;
    private String email;
    private String parola;
    private List<Rezervare> rezervari;

    public Utilizator(String nume, String email, String parola) {
        this.nume = nume;
        this.email = email;
        this.parola = parola;
        this.rezervari = new ArrayList<>();
    }

    public List<Zbor> cautaZboruri() {
        // Implementation for searching flights
        return new ArrayList<>();
    }

    public Rezervare rezervaZbor(Zbor zbor) {
        Rezervare rezervare = new Rezervare(this, zbor);
        rezervari.add(rezervare);
        return rezervare;
    }

    public void anuleazaRezervare(Rezervare rezervare) {
        rezervare.modificaStare("ANULATA");
        rezervari.remove(rezervare);
    }

    public List<Rezervare> vizualizeazaRezervari() {
        return new ArrayList<>(rezervari);
    }

    // Getters and setters
    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }
}