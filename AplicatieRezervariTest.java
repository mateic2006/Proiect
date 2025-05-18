import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

public class AplicatieRezervariTest {


    @Test
    public void testAutentificareUtilizator() {
        Client user = new Client("Ion Popescu", "ion@example.com", "parola123");
        assertEquals("Ion Popescu", user.getNume());
        assertEquals("ion@example.com", user.getEmail());
    }

    @Test
    public void testSolicitareSiIntroducereDataDestinatie() {
        String destinatie = "London";
        Date dataPlecare = new Date();
        Date dataSosire = new Date(System.currentTimeMillis() + 7200000);
        assertNotNull(destinatie);
        assertNotNull(dataPlecare);
        assertNotNull(dataSosire);
    }
    @Test
    public void testCautaZboruriDisponibilSiIndisponibil() {
        // Adauga zborul la compania TAROM din lista companiilor partenere
        CompanieAeriana tarom = null;
        for (CompanieAeriana c : AplicatieRezervari.companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) {
                tarom = c;
                break;
            }
        }
        assertNotNull(tarom);
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", new Date(), new Date(System.currentTimeMillis() + 7200000), 299.99, tarom);
        tarom.adaugaZbor(zbor);

        Client user = new Client("Test User", "test@example.com", "parola");

        // Cautare disponibila
        List<Zbor> rezultate = user.cautaZboruri("Bucuresti", "London");
        assertEquals(1, rezultate.size());
        assertEquals("London", rezultate.get(0).getOrasDestinatie());

        // Cautare indisponibila
        List<Zbor> rezultateIndisponibile = user.cautaZboruri("Bucuresti", "Istanbul");
        assertTrue(rezultateIndisponibile.isEmpty());
    }
    @Test
    public void testSelectareZborDorit() {
        CompanieAeriana tarom = null;
        for (CompanieAeriana c : AplicatieRezervari.companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) {
                tarom = c;
                break;
            }
        }
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", new Date(), new Date(System.currentTimeMillis() + 7200000), 299.99, tarom);
        Client user = new Client("Test User", "test@example.com", "parola");
        Rezervare rezervare = user.rezervaZbor(zbor);
        assertNotNull(rezervare);
        assertEquals(zbor, rezervare.getZbor());
    }

    @Test
    public void testIntroducereDatePersonale() {
        Client user = new Client("Ion Popescu", "ion@example.com", "parola123");
        assertEquals("Ion Popescu", user.getNume());
    }

    @Test
    public void testSelectareMetodaDePlataSiProcesare() {
        CompanieAeriana tarom = null;
        for (CompanieAeriana c : AplicatieRezervari.companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) {
                tarom = c;
                break;
            }
        }
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", new Date(), new Date(System.currentTimeMillis() + 7200000), 299.99, tarom);
        Client user = new Client("Test User", "test@example.com", "parola");
        Rezervare rezervare = user.rezervaZbor(zbor);
        Bilet bilet = new Bilet("TKT-001", zbor, user, "Ion Popescu");
        rezervare.adaugaBilet(bilet);
        Plata plata = new Plata("PAY-001", bilet.getPret());
        plata.efectueazaPlata(bilet.getPret());
        rezervare.adaugaPlata(plata);
        assertEquals("PLATIT", plata.verificaStatusPlata());
    }

    @Test
    public void testGenerareBilet() {
        CompanieAeriana tarom = null;
        for (CompanieAeriana c : AplicatieRezervari.companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) {
                tarom = c;
                break;
            }
        }
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", new Date(), new Date(System.currentTimeMillis() + 7200000), 299.99, tarom);
        Client user = new Client("Test User", "test@example.com", "parola");
        Bilet bilet = new Bilet("TKT-001", zbor, user, "Ion Popescu");
        assertEquals("TKT-001", bilet.getIdBilet());
    }

    @Test
    public void testConfirmareRezervare() {
        CompanieAeriana tarom = null;
        for (CompanieAeriana c : AplicatieRezervari.companiiPartenere) {
            if (c.getNume().equalsIgnoreCase("TAROM")) {
                tarom = c;
                break;
            }
        }
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", new Date(), new Date(System.currentTimeMillis() + 7200000), 299.99, tarom);
        Client user = new Client("Test User", "test@example.com", "parola");
        Rezervare rezervare = user.rezervaZbor(zbor);
        assertEquals(rezervare, user.vizualizeazaRezervari().get(0));
    }
}
