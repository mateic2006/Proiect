import java.util.ArrayList;
import java.util.List;

public class AplicatieRezervari {
    public static List<CompanieAeriana> companiiPartenere = new ArrayList<>();
    public static List<Rezervare> rezervariTest = new ArrayList<>();

    static {
        companiiPartenere.add(new CompanieAeriana("Wizz Air", "WZZ", "Budapesta, Ungaria"));
        companiiPartenere.add(new CompanieAeriana("TAROM", "RO-TAR", "Bucuresti, Romania"));
        companiiPartenere.add(new CompanieAeriana("Ryanair", "RYR", "Dublin, Irlanda"));
        companiiPartenere.add(new CompanieAeriana("Qatar Airways", "QTR", "Doha, Qatar"));

        // Adaugare rezervari de test
        Client clientTest1 = new Client("Test User 1", "test1@example.com", "parola1");
        Client clientTest2 = new Client("Test User 2", "test2@example.com", "parola2");
        CompanieAeriana tarom = null;
        CompanieAeriana wizz = null;
        for (CompanieAeriana c : companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) tarom = c;
            if (c.getNume().equalsIgnoreCase("Wizz Air")) wizz = c;
        }
        if (tarom != null) {
            Zbor zbor1 = new Zbor("RO100", "Bucuresti", "Paris", new java.util.Date(), new java.util.Date(System.currentTimeMillis() + 7200000), 150.0, tarom);
            tarom.adaugaZbor(zbor1);
            Rezervare rezervare1 = clientTest1.rezervaZbor(zbor1);
            rezervariTest.add(rezervare1);
        }
        if (wizz != null) {
            Zbor zbor2 = new Zbor("WZ200", "Cluj", "Roma", new java.util.Date(), new java.util.Date(System.currentTimeMillis() + 10800000), 120.0, wizz);
            wizz.adaugaZbor(zbor2);
            Rezervare rezervare2 = clientTest2.rezervaZbor(zbor2);
            rezervariTest.add(rezervare2);
        }
    }
}
