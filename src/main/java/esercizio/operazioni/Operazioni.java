package esercizio.operazioni;

import java.util.HashMap;
import java.util.Scanner;

import esercizio.models.*;

public class Operazioni {
	static HashMap<String, Dipendente> organico = new HashMap<String, Dipendente>();
	static Scanner scan = new Scanner(System.in);

	public static void Add() {

		System.out.print("Type the employee's name:\t");
		String nome = new String(scan.nextLine());
		System.out.print("Type the employee's surname:\t");
		String cognome = new String(scan.nextLine());

		if (organico.containsKey(chiave(nome.toLowerCase(), cognome.toLowerCase()))) {
			clearConsole();
			System.out.println("This employee has already been registered");

		} else {

			System.out.print("Type the employee's date of birth (dd/mm/yy):\t");
			String dob = new String(scan.nextLine());
			System.out.print("Type the employee's email address:\t");
			String email = new String(scan.nextLine());
			System.out.print("Type the employee's phone number:\t");
			String tel = new String(scan.nextLine());
			System.out.print("Type the employee's occupation (manager, developer or human resources):\t");
			String ruolo = new String(scan.nextLine());
			System.out.print("Is the employee a tester (yes/no)?:\t");
			String t = new String(scan.nextLine());
			boolean tester = false;
			if (t.toLowerCase().equals("yes")) {
				tester = true;
			}
			short id;
			String reparto;

			switch (ruolo) {
			case "manager":
				System.out.print("Type the employee's department:\t");
				reparto = new String(scan.nextLine());
				System.out.print("Type the employee's team ID:\t");
				id = (short) scan.nextInt();
				scan.nextLine();
				System.out.print("Type the employee's responsibility level [1,2,3]:\t");
				byte resp = (byte) scan.nextInt();
				scan.nextLine();
				Dirigente dir = new Dirigente(nome, cognome, dob, email, tel, ruolo, reparto, id, resp, tester);
				organico.put(chiave(nome, cognome), dir);
				clearConsole();
				break;
			case "developer":
				System.out.print("Type the employee's department:\t");
				reparto = new String(scan.nextLine());
				System.out.print("Type the employee's team ID:\t");
				id = (short) scan.nextInt();
				scan.nextLine();
				System.out.print("Type the employee's known programming language:\t");
				String linguaggio = new String(scan.nextLine());
				Sviluppatore dev = new Sviluppatore(nome, cognome, dob, email, tel, ruolo, reparto, id, linguaggio,
						tester);
				organico.put(chiave(nome, cognome), dev);
				clearConsole();
				break;
			case "human resources":
				RisorseUmane hr;
				System.out.print("Type the employee's task:\t");
				String mansione = new String(scan.nextLine());
				if (tester) {
					System.out.print("Type the employee's department:\t");
					reparto = new String(scan.nextLine());
					System.out.print("Type the employee's team ID:\t");
					id = (short) scan.nextInt();
					scan.nextLine();
					hr = new RisorseUmane(nome, cognome, dob, email, tel, ruolo, mansione, reparto, id, tester);
				} else {
					hr = new RisorseUmane(nome, cognome, dob, email, tel, ruolo, mansione, tester);
				}
				organico.put(chiave(nome, cognome), hr);
				clearConsole();
				break;
			default:
				if (tester) {
					System.out.print("Type the employee's department:\t");
					reparto = new String(scan.nextLine());
					System.out.print("Type the employee's team ID:\t");
					id = (short) scan.nextInt();
					scan.nextLine();
					Tester dip = new Tester(nome, cognome, dob, email, tel, ruolo, reparto, id, tester);
					organico.put(chiave(nome, cognome), dip);
				} else {
					Dipendente dip = new Dipendente(nome, cognome, dob, email, tel, ruolo, tester);
					organico.put(chiave(nome, cognome), dip);
				}

				clearConsole();
				break;
			}
		}

	}

	public static HashMap<String, Dipendente> Search(String query, HashMap<String, Dipendente> organico) {

		HashMap<String, Dipendente> result = new HashMap<String, Dipendente>();
		boolean check = false;

		if (organico.isEmpty()) {
			clearConsole();
			System.out.println("The list is empty");

		} else {

			while (!check) {
				switch (query.toLowerCase()) {

				case "name":
					System.out.print("Type the employee's name:\t");
					String name = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getNome().toLowerCase().equals(name.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);

						}
					}
					check = true;
					break;
				case "surname":
					System.out.print("Type the employee's surname:\t");
					String surname = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getCognome().toLowerCase().equals(surname.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;
				case "date of birth":
					System.out.print("Type the employee's date of birth (dd/mm/yy):\t");
					String dob = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getDob().toLowerCase().equals(dob.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;
				case "email":
					System.out.print("Type the employee's email address:\t");
					String email = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getEmail().toLowerCase().equals(email.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;
				case "phone number":
					System.out.print("Type the employee's phone number:\t");
					String num = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getNumTel().toLowerCase().equals(num.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;
				case "occupation":
					System.out.print("Type the employee's occupation (manager, developer or human resources):\t");
					String ruolo = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip.getRuolo().toLowerCase().equals(ruolo.toLowerCase())) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;
				case "department":
					System.out.print("Type the employee's department:\t");
					String reparto = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getReparto().toLowerCase().equals(reparto.toLowerCase())) {
								result.put(chiave(dir.getNome().toLowerCase(), dir.getCognome().toLowerCase()), dir);
							}
						} else if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getReparto().toLowerCase().equals(reparto.toLowerCase())) {
								result.put(chiave(dev.getNome().toLowerCase(), dev.getCognome().toLowerCase()), dev);
							}
						} else if (dip instanceof Tester) {
							Tester test = (Tester) dip;
							if (test.getReparto().toLowerCase().equals(reparto.toLowerCase())) {
								result.put(chiave(test.getNome().toLowerCase(), test.getCognome().toLowerCase()), test);
							}
						}
					}
					check = true;
					break;
				case "team id":
					System.out.print("Type the employee's team ID:\t");
					short id = (short) scan.nextInt();
					scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getIDTeam() == id) {
								result.put(chiave(dir.getNome().toLowerCase(), dir.getCognome().toLowerCase()), dir);
							}
						} else if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getIDTeam() == id) {
								result.put(chiave(dev.getNome().toLowerCase(), dev.getCognome().toLowerCase()), dev);
							}
						} else if (dip instanceof Tester) {
							Tester test = (Tester) dip;
							if (test.getIDTeam() == id) {
								result.put(chiave(test.getNome().toLowerCase(), test.getCognome().toLowerCase()), test);
							}
						}
					}
					check = true;
					break;
				case "responsibility":
					System.out.print("Type the employee's responsibility level [1,2,3]:\t");
					byte resp = (byte) scan.nextInt();
					scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Dirigente) {
							Dirigente dir = (Dirigente) dip;
							if (dir.getResponsabilita() == resp) {
								result.put(chiave(dir.getNome().toLowerCase(), dir.getCognome().toLowerCase()), dir);
							}
						}
					}
					check = true;
					break;
				case "language":
					System.out.print("Type the employee's known programming language:\t");
					String linguaggio = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof Sviluppatore) {
							Sviluppatore dev = (Sviluppatore) dip;
							if (dev.getLinguaggio().toLowerCase().equals(linguaggio.toLowerCase())) {
								result.put(chiave(dev.getNome().toLowerCase(), dev.getCognome().toLowerCase()), dev);
							}
						}
					}
					check = true;
					break;
				case "task":
					System.out.print("Type the employee's task:\t");
					String mansione = scan.nextLine();
					clearConsole();
					for (Dipendente dip : organico.values()) {
						if (dip instanceof RisorseUmane) {
							RisorseUmane hr = (RisorseUmane) dip;
							if (hr.getMansione().toLowerCase().equals(mansione.toLowerCase())) {
								result.put(chiave(hr.getNome().toLowerCase(), hr.getCognome().toLowerCase()), hr);
							}
						}
					}
					check = true;
					break;

				case "tester":
					for (Dipendente dip : organico.values()) {
						if (dip.getTester()) {
							result.put(chiave(dip.getNome().toLowerCase(), dip.getCognome().toLowerCase()), dip);
						}
					}
					check = true;
					break;

				default:
					System.out.println("The input was not correct, retry\n");
					break;
				}
				break;// FINE SWITCH
			} // FINE WHILE
		}
		return result;
	}

	public static void Update() {

		String reparto = new String();
		short id;

		if (organico.isEmpty()) {
			clearConsole();
			System.out.println("The list is empty");

		} else {

			String check = new String("yes");
			System.out.print("Type the employee's name and surname with a space in between:\t");
			String key = scan.nextLine();
			clearConsole();
			if (organico.containsKey(key)) {

				do {

					System.out.println("\n" + organico.get(key).toString() + "\n");
					System.out.println(
							"Type the attribute to edit:\n Name\t\tSurname\t\tDate of birth\t\tEmail\t\tPhone number\t\tOccupation\t\tTester\t\tOccupation");
					String query = scan.nextLine();

					switch (query.toLowerCase()) {

					case "name":
						System.out.print("Type the employee's name:\t");
						String name = scan.nextLine();
						String prevKey = new String(key);
						organico.get(prevKey).setNome(name);
						key = chiave(name, organico.get(prevKey).getCognome());
						organico.put(key, organico.get(prevKey));
						organico.remove(prevKey);
						break;

					case "surname":
						System.out.print("Type the employee's surname:\t");
						String surname = scan.nextLine();
						prevKey = new String(key);
						organico.get(prevKey).setCognome(surname);
						key = chiave(organico.get(prevKey).getNome(), surname);
						organico.put(key, organico.get(prevKey));
						organico.remove(prevKey);
						break;

					case "date of birth":
						System.out.print("Type the employee's date of birth (dd/mm/yy):\t");
						String dob = scan.nextLine();
						organico.get(key).setDob(dob);
						break;

					case "email":
						System.out.print("Type the employee's email address:\t");
						String email = scan.nextLine();
						organico.get(key).setEmail(email);
						break;

					case "phone number":
						System.out.print("Type the employee's phone number:\t");
						String num = scan.nextLine();
						organico.get(key).setNumTel(num);
						break;

					case "tester":
						System.out.print("Is the employee a tester (yes/no):\t");
						String t = scan.nextLine();
						if (t.toLowerCase().equals("yes")) {
							if (organico.get(key).getTester()) {
								System.out.println("The employee is already a tester");
							} else
								organico.get(key).toggleTester(true);
						} else
							organico.get(key).toggleTester(false);

						break;

					case "occupation":
						System.out.print("Type the employee's occupation:\t");
						String ruolo = scan.nextLine();
						organico.get(key).setRuolo(ruolo);

						switch (ruolo) {

						case "manager":
							System.out.print("Type the employee's department:\t");
							reparto = new String(scan.nextLine());
							System.out.print("Type the employee's team ID:\t");
							id = (short) scan.nextInt();
							scan.nextLine();
							System.out.print("Type the employee's responsibility level [1,2,3]:\t");
							byte resp = (byte) scan.nextInt();
							scan.nextLine();
							Dirigente dir = new Dirigente(organico.get(key).getNome(), organico.get(key).getCognome(),
									organico.get(key).getDob(), organico.get(key).getEmail(),
									organico.get(key).getNumTel(), ruolo, reparto, id, resp,
									organico.get(key).getTester());
							organico.remove(key);
							organico.put(chiave(dir.getNome(), dir.getCognome()), dir);
							break;

						case "developer":
							System.out.print("Type the employee's department:\t");
							reparto = new String(scan.nextLine());
							System.out.print("Type the employee's team ID:\t");
							id = (short) scan.nextInt();
							scan.nextLine();
							System.out.print("Type the employee's known programming language:\t");
							String linguaggio = new String(scan.nextLine());
							Sviluppatore dev = new Sviluppatore(organico.get(key).getNome(),
									organico.get(key).getCognome(), organico.get(key).getDob(),
									organico.get(key).getEmail(), organico.get(key).getNumTel(), ruolo, reparto, id,
									linguaggio, organico.get(key).getTester());
							organico.remove(key);
							organico.put(chiave(dev.getNome(), dev.getCognome()), dev);
							break;

						case "human resources":
							RisorseUmane hr;
							System.out.print("Type the employee's task:\t");
							String mansione = new String(scan.nextLine());
							System.out.print("Type the employee's department:\t");
							reparto = new String(scan.nextLine());
							System.out.print("Type the employee's team ID:\t");
							id = (short) scan.nextInt();
							scan.nextLine();
							if (organico.get(key).getTester()) {
								hr = new RisorseUmane(organico.get(key).getNome(), organico.get(key).getCognome(),
										organico.get(key).getDob(), organico.get(key).getEmail(),
										organico.get(key).getNumTel(), ruolo, mansione, reparto, id,
										organico.get(key).getTester());
							} else {
								hr = new RisorseUmane(organico.get(key).getNome(), organico.get(key).getCognome(),
										organico.get(key).getDob(), organico.get(key).getEmail(),
										organico.get(key).getNumTel(), ruolo, mansione, organico.get(key).getTester());
							}
							organico.remove(key);
							organico.put(chiave(hr.getNome(), hr.getCognome()), hr);
							break;

						default:
							Dipendente dip = new Dipendente(organico.get(key).getNome(), organico.get(key).getCognome(),
									organico.get(key).getDob(), organico.get(key).getEmail(),
									organico.get(key).getNumTel(), ruolo, organico.get(key).getTester());
							organico.remove(key);
							organico.put(chiave(dip.getNome(), dip.getCognome()), dip);
						}
						break;
					default:
						clearConsole();
						System.out.println("The input was not correct, retry\n");
						// break;
					}
					System.out.print("Keep editing the data?\t");
					check = new String(scan.nextLine());
					clearConsole();
				} while (check.toLowerCase().equals("yes"));
			} else {
				clearConsole();
				System.out.println("Employee not found");
			}
		}
	}

	public static void Delete() {
		System.out.print("Type the employee's name and surname with a space in between:\t");
		String k = scan.nextLine().toLowerCase();
		if (organico.containsKey(k)) {
			organico.remove(k);
			clearConsole();
		} else
			System.out.println("Employee not found");
	}

	public static String chiave(String nome, String cognome) {
		return nome.toLowerCase() + " " + cognome.toLowerCase();
	}

	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public static HashMap<String, Dipendente> getOrganico() {
		return organico;
	}

}
