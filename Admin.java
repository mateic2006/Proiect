public class Admin extends Utilizator {
    public Admin(String nume, String email, String parola) {
        super(nume, email, parola);
    }

    public void adaugaZbor(Zbor zbor) {
        zbor.getCompanieAeriana().adaugaZbor(zbor);
    }

    public void stergeZbor(Zbor zbor) {
        zbor.getCompanieAeriana().stergeZbor(zbor);
    }

    public void modificaDetaliiZbor(Zbor zbor, Zbor detaliiModificate) {
        zbor.getCompanieAeriana().modificaZbor(detaliiModificate);
    }
}