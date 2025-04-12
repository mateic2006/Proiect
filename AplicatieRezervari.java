import java.util.Date;

public class AplicatieRezervari {
    public static void main(String[] args) {
        // Create an airline company
        CompanieAeriana tarom = new CompanieAeriana("TAROM", "RO-TAR", "Bucuresti, Romania");

        // Create a flight
        Zbor zbor = new Zbor("RO123", "Bucuresti", "London", 
            new Date(), new Date(System.currentTimeMillis() + 7200000), 
            299.99, tarom);
        tarom.adaugaZbor(zbor);

        // Create a regular user
        Utilizator user = new Utilizator("Ion Popescu", "ion@example.com", "parola123");

        // Create an admin
        Admin admin = new Admin("Admin User", "admin@example.com", "admin123");

        // User searches for flights and makes a reservation
        System.out.println("Available flights:");
        System.out.println(zbor.afiseazaDetalii());

        Rezervare rezervare = user.rezervaZbor(zbor);
        System.out.println("\nReservation created with ID: " + rezervare.getIdRezervare());

        // Create and add ticket
        Bilet bilet = new Bilet("TKT-001", zbor, user, "Ion Popescu");
        rezervare.adaugaBilet(bilet);
        System.out.println("\nTicket details:");
        System.out.println(bilet.afiseazaDetalii());

        // Process payment
        Plata plata = new Plata("PAY-001", bilet.getPret());
        plata.efectueazaPlata(bilet.getPret());
        rezervare.adaugaPlata(plata);
        System.out.println("\nPayment status: " + plata.verificaStatusPlata());

        // Admin operations
        System.out.println("\nAdmin modifying flight details...");
        Zbor zborModificat = new Zbor("RO123", "Bucuresti", "London", 
            new Date(), new Date(System.currentTimeMillis() + 8200000), 
            319.99, tarom);
        admin.modificaDetaliiZbor(zbor, zborModificat);

        // Show updated flight details
        System.out.println("\nUpdated flight details:");
        System.out.println(zborModificat.afiseazaDetalii());
    }
}