package esercizio.operazioni;

import java.util.HashMap;
import java.util.Scanner;

import esercizio.models.*;

public class Operazioni {

    static HashMap<String, Dipendente> organico = new HashMap<String, Dipendente>();
    static Scanner scan = new Scanner(System.in);

    public static void Add() {

        System.out.print("Inserire il nome del dipendente:\t");
        String nome = new String(scan.nextLine());
        System.out.print("Inserire il cognome del dipendente:\t");
        String cognome = new String(scan.nextLine());

        if (organico.containsKey(chiave(nome.toLowerCase(), cognome.toLowerCase()))) {
            clearConsole();
            System.out.println("Dipendente già presente");

        } else {

            System.out.print("Inserire la data di nascita:\t");
            String dob = new String(scan.nextLine());
            System.out.print("Inserire l'indirizzo email:\t");
            String email = new String(scan.nextLine());
            System.out.print("Inserire il numero di telefono:\t");
            String tel = new String(scan.nextLine());
            System.out.print("Inserire il ruolo:\t");
            String ruolo = new String(scan.nextLine());
            System.out.print("Specificare se è un tester (sì/no):\t");
            String t = new String(scan.nextLine());
            boolean tester = false;
            if (t.toLowerCase().equals("sì") || t.toLowerCase().equals("si"))
                tester = true;
            switch (ruolo) {
                case "dirigente":
                    System.out.print("Inserire il reparto:\t");
                    String reparto = new String(scan.nextLine());
                    System.out.print("Inserire l'ID del team con cui lavora:\t");
                    short id = (short) scan.nextInt();
                    System.out.print("Inserire l'indicatore di responsabilità [1,2,3]:\t");
                    byte resp = (byte) scan.nextInt();
                    Dirigente dir = new Dirigente(nome, cognome, dob, email, tel, ruolo, tester, reparto, id, resp);
                    organico.put(chiave(nome, cognome), dir);
                    break;
                case "sviluppatore":
                    System.out.print("Inserire il reparto:\t");
                    String repart = new String(scan.nextLine());
                    System.out.print("Inserire l'ID del team con cui lavora:\t");
                    short id1 = (short) scan.nextInt();
                    System.out.print("Inserire il linguaggio di programmazione:\t");
                    String linguaggio = new String(scan.nextLine());
                    Sviluppatore dev = new Sviluppatore(nome, cognome, dob, email, tel, ruolo, tester, repart, id1,
                            linguaggio);
                    organico.put(chiave(nome, cognome), dev);
                    break;
                case "risorse umane":
                    break;
                default:
                    Dipendente dip = new Dipendente(nome, cognome, dob, email, tel, ruolo, tester);
                    organico.put(chiave(nome, cognome), dip);
                    clearConsole();
                    break;
            }
        }

    }

    public static void Search() {

        if (organico.isEmpty()) {
            clearConsole();
            System.out.println("La lista è vuota");

        } else {

            System.out.println(
                    "Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo");
            String query = scan.nextLine();

            switch (query.toLowerCase()) {

                case "nome":
                    System.out.print("Digitare il nome:\t");
                    String name = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getNome().toLowerCase().equals(name.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                case "cognome":
                    System.out.print("Digitare il cognome:\t");
                    String surname = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getCognome().toLowerCase().equals(surname.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                case "data di nascita":
                    System.out.print("Digitare la data di nascita (gg/mm/yy):\t");
                    String dob = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getDob().toLowerCase().equals(dob.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                case "email":
                    System.out.print("Digitare l'indirizzo email:\t");
                    String email = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getEmail().toLowerCase().equals(email.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                case "numero telefonico":
                    System.out.print("Digitare il numero telefonico:\t");
                    String num = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getNumTel().toLowerCase().equals(num.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                case "ruolo":
                    System.out.print("Digitare il ruolo:\t");
                    String ruolo = scan.nextLine();
                    for (Dipendente dip : organico.values()) {
                        if (dip.getRuolo().toLowerCase().equals(ruolo.toLowerCase())) {
                            stampaInformazioni(dip);
                        }
                    }
                    break;
                default:
                    clearConsole();
                    System.out.println("Input non corretto, riprovare");
            }
        }

    }

    public static void Update() {
        if (organico.isEmpty()) {
            clearConsole();
            System.out.println("La lista è vuota");

        } else {

            System.out.print(
                    "Immettere nome e cognome separati da uno spazio dell'impiegato del quale si vogliono modificare i dati:\t");
            String key = scan.nextLine();
            if (organico.containsKey(key)) {
                System.out.println("\n" + organico.get(key).dettagli() + "\n");
                System.out.println(
                        "Immettere l'attributo da modificare fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo");
                String update = scan.nextLine();

                switch (update.toLowerCase()) {

                    case "nome":
                        System.out.print("Digitare il nome:\t");
                        String name = scan.nextLine();
                        organico.get(key).setNome(name);
                        organico.put(chiave(name, organico.get(key).getCognome()), organico.get(key));
                        organico.remove(key);

                        break;
                    case "cognome":
                        System.out.print("Digitare il cognome:\t");
                        String surname = scan.nextLine();
                        organico.get(key).setCognome(surname);
                        organico.put(chiave(organico.get(key).getNome(), surname), organico.get(key));
                        organico.remove(key);
                        break;
                    case "data di nascita":
                        System.out.print("Digitare la data di nascita (gg/mm/yy):\t");
                        String dob = scan.nextLine();
                        organico.get(key).setDob(dob);
                        break;
                    case "email":
                        System.out.print("Digitare l'indirizzo email:\t");
                        String email = scan.nextLine();
                        organico.get(key).setEmail(email);
                        break;
                    case "numero telefonico":
                        System.out.print("Digitare il numero telefonico:\t");
                        String num = scan.nextLine();
                        organico.get(key).setNumTel(num);
                        break;
                    case "ruolo":
                        System.out.print("Digitare il ruolo:\t");
                        String ruolo = scan.nextLine();
                        organico.get(key).setRuolo(ruolo);
                        break;
                    default:
                        clearConsole();
                        System.out.println("Input non corretto, riprovare");
                }
            }
            clearConsole();
        }
    }

    public static void Delete() {
        System.out.print(
                "Digitare il nome e il cognome del dipendente da eliminare separati da uno spazio:\t");
        String k = scan.nextLine().toLowerCase();
        if (organico.containsKey(k)) {
            organico.remove(k);
            clearConsole();
        } else
            System.out.println("Il dipendente non esiste");
    }

    public static String chiave(String nome, String cognome) {
        return nome.toLowerCase() + " " + cognome.toLowerCase();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void stampaInformazioni(Dipendente dip) {
        clearConsole();
        System.out.println(dip.dettagli());
    }

}
