import java.util.Date;

public class Plata {
    private String idPlata;
    private Double suma;
    private Date dataPlata;
    private String status;

    public Plata(String idPlata, Double suma) {
        this.idPlata = idPlata;
        this.suma = suma;
        this.dataPlata = new Date();
        this.status = "IN_ASTEPTARE";
    }

    public void efectueazaPlata(Double suma) {
        this.suma = suma;
        this.dataPlata = new Date();
        this.status = "PLATIT";
    }

    public String verificaStatusPlata() {
        return this.status;
    }

    // Getters
    public String getIdPlata() {
        return idPlata;
    }

    public Double getSuma() {
        return suma;
    }

    public Date getDataPlata() {
        return dataPlata;
    }
}