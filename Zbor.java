import java.util.Date;

public class Zbor {
    private String numarZbor;
    private String orasPlecare;
    private String orasDestinatie;
    private Date dataPlecare;
    private Date dataSosire;
    private Double pret;
    private CompanieAeriana companieAeriana;

    public Zbor(String numarZbor, String orasPlecare, String orasDestinatie, 
                Date dataPlecare, Date dataSosire, Double pret, CompanieAeriana companieAeriana) {
        this.numarZbor = numarZbor;
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
        this.dataPlecare = dataPlecare;
        this.dataSosire = dataSosire;
        this.pret = pret;
        this.companieAeriana = companieAeriana;
    }

    public Double calculeazaPret() {
        return this.pret;
    }

    public String afiseazaDetalii() {
        return String.format("Zbor %s: %s -> %s, Plecare: %s, Sosire: %s, Companie: %s, Pret: %.2f",
            numarZbor, orasPlecare, orasDestinatie, dataPlecare, dataSosire, 
            companieAeriana.getNume(), pret);
    }

    // Getters
    public String getNumarZbor() {
        return numarZbor;
    }

    public String getOrasPlecare() {
        return orasPlecare;
    }

    public String getOrasDestinatie() {
        return orasDestinatie;
    }

    public Date getDataPlecare() {
        return dataPlecare;
    }

    public Date getDataSosire() {
        return dataSosire;
    }

    public Double getPret() {
        return pret;
    }

    public CompanieAeriana getCompanieAeriana() {
        return companieAeriana;
    }
}