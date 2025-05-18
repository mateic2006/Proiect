import java.util.Date;

public class Rezervare {
    private String idRezervare;
    private Utilizator utilizator;
    private Zbor zbor;
    private Date dataRezervare;
    private String stare;
    private Bilet bilet;
    private Plata plata;
    public Rezervare(Utilizator utilizator, Zbor zbor) {
        this.utilizator = utilizator;
        this.zbor = zbor;
        this.dataRezervare = new Date();
        this.stare = "IN_ASTEPTARE";
        this.idRezervare = generateId();
    }

    private String generateId() {
        return "REZ-" + System.currentTimeMillis();
    }

    public void modificaStare(String stare) {
        this.stare = stare;
    }

    public void adaugaBilet(Bilet bilet) {
        this.bilet = bilet;
    }

    public void adaugaPlata(Plata plata) {
        this.plata = plata;
    }

    public String getStare() {
        return stare;
    }

    public String getIdRezervare() {
        return idRezervare;
    }

    public Zbor getZbor() {
        return zbor;
    }

    public Bilet getBilet() {
        return bilet;
    }

    public Plata getPlata() {
        return plata;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public Date getDataRezervare() {
        return dataRezervare;
    }
}