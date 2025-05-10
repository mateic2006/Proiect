# Aplicație Rezervare Zboruri

Această aplicație Java permite gestionarea rezervărilor de zboruri pentru utilizatori (clienți) și administratori, modelând un sistem real de rezervare a biletelor de avion.

## Funcționalități principale
- **Autentificare utilizator** (Client/Admin)
- **Căutare zboruri** la companii aeriene partenere (Wizz Air, TAROM, Ryanair, Qatar Airways)
- **Rezervare zbor** și generare bilet
- **Procesare plată** pentru rezervare
- **Vizualizare și anulare rezervări**
- **Administrare zboruri** (doar pentru Admin)

## Structură clase principale
- `Utilizator` – clasa de bază pentru utilizatori
- `Client` – moștenește Utilizator, poate căuta și rezerva zboruri
- `Admin` – moștenește Utilizator, poate adăuga/modifica/șterge zboruri
- `CompanieAeriana` – reprezintă o companie aeriană parteneră
- `Zbor` – detalii despre un zbor
- `Rezervare` – rezervare efectuată de un client
- `Bilet` – bilet generat pentru o rezervare
- `Plata` – procesarea plății pentru rezervare

## Diagrame
- Diagrama de activități pentru rezervare zbor: `Proiect/Imagini/activitati.jpg`
- Diagrama de clase: `Proiect/Imagini/clase.jpg`

## Testare
Testele JUnit acoperă fiecare pas din fluxul de rezervare, inclusiv:
- Autentificare
- Căutare zboruri (disponibil/indisponibil)
- Rezervare, plată, generare bilet, confirmare

Rulează testele cu:
```
javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar Proiect/*.java
java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore Proiect.AplicatieRezervariTest
```

## Cum rulezi aplicația
1. Compilează toate fișierele Java:
   ```
   javac Proiect/*.java
   ```
2. Rulează aplicația principală:
   ```
   java Proiect.AplicatieRezervari
   ```

## Autori
- [Constantin Matei]

## Observații
- Aplicația este pentru uz educațional și poate fi extinsă cu funcționalități suplimentare (preferințe, notificări, etc).
