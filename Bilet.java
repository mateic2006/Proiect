public class Bilet {
    private String idBilet;
    private Zbor zbor;
    private Utilizator utilizator;
    private String persoanaContact;
    private Double pret;

    public Bilet(String idBilet, Zbor zbor, Utilizator utilizator, String persoanaContact) {
        this.idBilet = idBilet;
        this.zbor = zbor;
        this.utilizator = utilizator;
        this.persoanaContact = persoanaContact;
        this.pret = calculeazaPret();
    }

    public Double calculeazaPret() {
        return zbor.getPret();
    }

    public String afiseazaDetalii() {
        return String.format("Bilet %s pentru zborul %s, pasager: %s, contact: %s, pret: %.2f", 
            idBilet, zbor.getNumarZbor(), utilizator.getNume(), persoanaContact, pret);
    }

    // Getters
    public String getIdBilet() {
        return idBilet;
    }

    public Zbor getZbor() {
        return zbor;
    }

    public Double getPret() {
        return pret;
    }
}