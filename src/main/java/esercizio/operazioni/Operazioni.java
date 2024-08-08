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
				scan.nextLine();
				System.out.print("Inserire l'indicatore di responsabilità [1,2,3]:\t");
				byte resp = (byte) scan.nextInt();
				scan.nextLine();
				Dirigente dir = new Dirigente(nome, cognome, dob, email, tel, ruolo, tester, reparto, id, resp);
				organico.put(chiave(nome, cognome), dir);
				break;
			case "sviluppatore":
				System.out.print("Inserire il reparto:\t");
				String repart = new String(scan.nextLine());
				System.out.print("Inserire l'ID del team con cui lavora:\t");
				short id1 = (short) scan.nextInt();
				scan.nextLine();
				System.out.print("Inserire il linguaggio di programmazione:\t");
				String linguaggio = new String(scan.nextLine());
				Sviluppatore dev = new Sviluppatore(nome, cognome, dob, email, tel, ruolo, tester, repart, id1,
						linguaggio);
				organico.put(chiave(nome, cognome), dev);
				break;
			case "risorse umane":
				System.out.print("Inserire la mansione:\t");
				String mansione = new String(scan.nextLine());
				RisorseUmane hr = new RisorseUmane(nome, cognome, dob, email, tel, ruolo, tester, mansione);
				organico.put(chiave(nome, cognome), hr);
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

		boolean check = false;

		if (organico.isEmpty()) {
			clearConsole();
			System.out.println("La lista è vuota");

		} else {

			while (!check) {
				System.out.println(
						"Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo\t\tReparto\t\tID Team\t\tResponsabilità\t\tLinguaggio\t\tMansione");
				String query = scan.nextLine();
				switch (query.toLowerCase()) {

				case "nome":
					System.out.print("Digitare il nome:\t");
					String name = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getNome().toLowerCase().equals(name.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "cognome":
					System.out.print("Digitare il cognome:\t");
					String surname = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getCognome().toLowerCase().equals(surname.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "data di nascita":
					System.out.print("Digitare la data di nascita (gg/mm/yy):\t");
					String dob = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getDob().toLowerCase().equals(dob.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "email":
					System.out.print("Digitare l'indirizzo email:\t");
					String email = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getEmail().toLowerCase().equals(email.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "numero telefonico":
					System.out.print("Digitare il numero telefonico:\t");
					String num = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getNumTel().toLowerCase().equals(num.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "ruolo":
					System.out.print("Digitare il ruolo:\t");
					String ruolo = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getRuolo().toLowerCase().equals(ruolo.toLowerCase())) {
							System.out.println(dip.toString());
						}
					}
					check = true;
					break;
				case "reparto":
					System.out.print("Digitare il reparto:\t");
					String reparto = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getReparto().toLowerCase().equals(reparto.toLowerCase())) {
								System.out.println(dir.toString());
							}
						} else if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getReparto().toLowerCase().equals(reparto.toLowerCase())) {
								System.out.println(dev.toString());
							}
						}
					}
					check = true;
					break;
				case "id team":
					System.out.print("Digitare l'identificativo del team:\t");
					short id = (short) scan.nextInt();
					scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getIDTeam() == id) {
								System.out.println(dir.toString());
							}
						} else if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getIDTeam() == id) {
								System.out.println(dev.toString());
							}
						}
					}
					check = true;
					break;
				case "responsabilità":
					System.out.print("Digitare il grado di responsabilità:\t");
					byte resp = (byte) scan.nextInt();
					scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getResponsabilita() == resp) {
								System.out.println(dir.toString());
							}
						}
					}
					check = true;
					break;
				case "linguaggio":
					System.out.print("Digitare il linguaggio di programmazione:\t");
					String linguaggio = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getLinguaggio().toLowerCase().equals(linguaggio.toLowerCase())) {
								System.out.println(dev.toString());
							}
						}
					}
					check = true;
					break;
				case "mansione":
					System.out.print("Digitare la mansione:\t");
					String mansione = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof RisorseUmane) {
							RisorseUmane hr = (RisorseUmane) dip;
							if (hr.getMansione().toLowerCase().equals(mansione.toLowerCase())) {
								System.out.println(hr.toString());
							}
						}
					}
					check = true;
					break;

				default:
					System.out.println("Input non corretto, riprovare\n");
					break;
				}
			}
		}
	}

	public static void Update() {
		if (organico.isEmpty()) {
			clearConsole();
			System.out.println("La lista è vuota");

		} else {

			String check = new String("sì");
			System.out.print(
					"Immettere nome e cognome separati da uno spazio dell'impiegato del quale si vogliono modificare i dati:\t");
			String key = scan.nextLine();
			if (organico.containsKey(key)) {

				do {
					
					System.out.println("\n" + organico.get(key).toString() + "\n");
					System.out.println(
							"Immettere l'attributo da modificare fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo");
					String query = scan.nextLine();

					switch (query.toLowerCase()) {

					case "nome":
						System.out.print("Digitare il nome:\t");
						String name = scan.nextLine();
						String prevKey = new String(key);
						organico.get(prevKey).setNome(name);
						key = chiave(name, organico.get(prevKey).getCognome());
						organico.put(key, organico.get(prevKey));						
						organico.remove(prevKey);
						
						break;

					case "cognome":
						System.out.print("Digitare il cognome:\t");
						String surname = scan.nextLine();
						prevKey = new String(key);
						organico.get(prevKey).setCognome(surname);
						key = chiave(organico.get(prevKey).getNome(), surname);
						organico.put(key, organico.get(prevKey));						
						organico.remove(prevKey);
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

						switch (ruolo) {

						case "dirigente":
							System.out.print("Inserire il reparto:\t");
							String reparto = new String(scan.nextLine());
							System.out.print("Inserire l'ID del team con cui lavora:\t");
							short id = (short) scan.nextInt();
							scan.nextLine();
							System.out.print("Inserire l'indicatore di responsabilità [1,2,3]:\t");
							byte resp = (byte) scan.nextInt();
							scan.nextLine();
							Dirigente dir = new Dirigente(organico.get(key).getNome(), organico.get(key).getCognome(),
									organico.get(key).getDob(), organico.get(key).getEmail(),
									organico.get(key).getNumTel(), ruolo, organico.get(key).getTesterBool(), reparto,
									id, resp);
							organico.remove(key);
							organico.put(chiave(dir.getNome(), dir.getCognome()), dir);
							break;

						case "sviluppatore":
							System.out.print("Inserire il reparto:\t");
							String reparto1 = new String(scan.nextLine());
							System.out.print("Inserire l'ID del team con cui lavora:\t");
							short id1 = (short) scan.nextInt();
							scan.nextLine();
							System.out.print("Inserire il linguaggio di programmazione:\t");
							String linguaggio = new String(scan.nextLine());
							Sviluppatore dev = new Sviluppatore(organico.get(key).getNome(),
									organico.get(key).getCognome(), organico.get(key).getDob(),
									organico.get(key).getEmail(), organico.get(key).getNumTel(), ruolo,
									organico.get(key).getTesterBool(), reparto1, id1, linguaggio);
							organico.remove(key);
							organico.put(chiave(dev.getNome(), dev.getCognome()), dev);
							break;

						case "risorse umane":
							System.out.print("Inserire La mansione:\t");
							String mansione = new String(scan.nextLine());
							RisorseUmane hr = new RisorseUmane(organico.get(key).getNome(),
									organico.get(key).getCognome(), organico.get(key).getDob(),
									organico.get(key).getEmail(), organico.get(key).getNumTel(), ruolo,
									organico.get(key).getTesterBool(), mansione);
							organico.remove(key);
							organico.put(chiave(hr.getNome(), hr.getCognome()), hr);
							break;

						default:
							Dipendente dip = new Dipendente(organico.get(key).getNome(), organico.get(key).getCognome(),
									organico.get(key).getDob(), organico.get(key).getEmail(),
									organico.get(key).getNumTel(), ruolo, organico.get(key).getTesterBool());
							organico.remove(key);
							organico.put(chiave(dip.getNome(), dip.getCognome()), dip);
						}
						break;
					default:
						clearConsole();
						System.out.println("Input non corretto, riprovare");
					}
					System.out.println("Effettuare una nuova modifica?");
					check = new String(scan.nextLine());
				} while (check.toLowerCase().equals("sì") | check.toLowerCase().equals("si"));

			}
			clearConsole();
		}
	}

	public static void Delete() {
		System.out.print("Digitare il nome e il cognome del dipendente da eliminare separati da uno spazio:\t");
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

}
