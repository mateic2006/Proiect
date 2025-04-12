import java.util.List;
import java.util.ArrayList;

public class CompanieAeriana {
    private String nume;
    private String codIATA;
    private String adresa;
    private List<Zbor> zboruri;

    public CompanieAeriana(String nume, String codIATA, String adresa) {
        this.nume = nume;
        this.codIATA = codIATA;
        this.adresa = adresa;
        this.zboruri = new ArrayList<>();
    }

    public void adaugaZbor(Zbor zbor) {
        zboruri.add(zbor);
    }

    public void modificaZbor(Zbor zbor) {
        // Implementation for modifying flight details
        int index = zboruri.indexOf(zbor);
        if (index != -1) {
            zboruri.set(index, zbor);
        }
    }

    public void stergeZbor(Zbor zbor) {
        zboruri.remove(zbor);
    }

    // Getters
    public String getNume() {
        return nume;
    }

    public String getCodIATA() {
        return codIATA;
    }

    public List<Zbor> getZboruri() {
        return new ArrayList<>(zboruri);
    }

    public String getAdresa() {
        return adresa;
    }
}