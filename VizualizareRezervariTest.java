import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class VizualizareRezervariTest {
    @Test
    public void testRezervariDinAplicatieRezervari() {
        // Testam ca rezervarile de test din AplicatieRezervari sunt corect adaugate si asociate clientului
        List<Rezervare> rezervari = AplicatieRezervari.rezervariTest;
        assertNotNull(rezervari);
        assertEquals(2, rezervari.size());

        Rezervare rezervare1 = rezervari.get(0);
        Rezervare rezervare2 = rezervari.get(1);

        // Verificam ca fiecare rezervare are un utilizator asociat si un zbor valid
        assertNotNull(rezervare1.getUtilizator());
        assertNotNull(rezervare1.getZbor());
        assertNotNull(rezervare2.getUtilizator());
        assertNotNull(rezervare2.getZbor());

        // Verificam ca rezervarile apar in lista clientului
        List<Rezervare> rezervariClient1 = ((Client)rezervare1.getUtilizator()).vizualizeazaRezervari();
        List<Rezervare> rezervariClient2 = ((Client)rezervare2.getUtilizator()).vizualizeazaRezervari();
        assertTrue(rezervariClient1.contains(rezervare1));
        assertTrue(rezervariClient2.contains(rezervare2));
    }
}
