import java.util.ArrayList;
import java.util.List;

public class Client extends Utilizator {
    private List<Rezervare> rezervari;

    public Client(String nume, String email, String parola) {
        super(nume, email, parola);
        this.rezervari = new ArrayList<>();
    }

    public List<Zbor> cautaZboruri(String orasPlecare, String orasDestinatie) {
        List<Zbor> rezultate = new ArrayList<>();
        for (CompanieAeriana companie : AplicatieRezervari.companiiPartenere) {
            for (Zbor zbor : companie.getZboruri()) {
                if (zbor.getOrasPlecare().equalsIgnoreCase(orasPlecare) &&
                    zbor.getOrasDestinatie().equalsIgnoreCase(orasDestinatie)) {
                    rezultate.add(zbor);
                }
            }
        }
        return rezultate;
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
    // Add client-specific methods here if needed
}
