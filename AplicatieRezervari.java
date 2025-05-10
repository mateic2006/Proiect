import java.util.ArrayList;
import java.util.List;

public class AplicatieRezervari {
    public static List<CompanieAeriana> companiiPartenere = new ArrayList<>();

    static {
        companiiPartenere.add(new CompanieAeriana("Wizz Air", "WZZ", "Budapesta, Ungaria"));
        companiiPartenere.add(new CompanieAeriana("TAROM", "RO-TAR", "Bucuresti, Romania"));
        companiiPartenere.add(new CompanieAeriana("Ryanair", "RYR", "Dublin, Irlanda"));
        companiiPartenere.add(new CompanieAeriana("Qatar Airways", "QTR", "Doha, Qatar"));
    }
}
