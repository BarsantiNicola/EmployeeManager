import esercizio.operazioni.*;
import esercizio.models.*;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {
	public static void main(String args[]) {
		
		HashMap<String, Dipendente> prevRisultato = new HashMap<String, Dipendente>();
		HashMap<String, Dipendente> risultato = new HashMap<String, Dipendente>();

		Scanner scan = new Scanner(System.in);
		char c = ' ';
		while (c != 'e') {
			System.out.println(
					"Available commands:\n - Add Employee(a)\n - Search Employees(s)\n - Update Employee(u)\n - Delete Employee(d)\n - Exit(e)\n\nSelect Command:");

			String command = scan.nextLine().toLowerCase();
			c = command.charAt(0);

			switch (c) {
				case 'a': // ADD
					Operazioni.Add();
					break;
				case 's': // SEARCH
					String check = new String("sì");
					//prevRisultato.clear();
					//risultato.clear();
					
					risultato = (HashMap)Operazioni.getOrganico().clone();
					while (check.toLowerCase().equals("sì") || check.toLowerCase().equals("si")) {
						System.out.println(
								"Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo\t\tReparto\t\tID Team\t\tResponsabilità\t\tLinguaggio\t\tMansione");
						String query = scan.nextLine();
						prevRisultato = (HashMap)risultato.clone();
						risultato = (HashMap)Operazioni.Search(query, prevRisultato).clone();
						for(Dipendente dip : risultato.values()) {
							dip.toString();
						}
						System.out.println("Effettuare una nuova ricerca?");
						check = new String(scan.nextLine());
						
					}
					Operazioni.clearConsole();
					//System.out.println(risultato);
					break;
				case 'u': // UPDATE
					Operazioni.Update();
					break;
				case 'd': // DELETE
					Operazioni.Delete();
					break;
				case 'e': // EXIT
					break;
				default:
					System.out.println("Input non corretto, riprovare");
			}
		}
	}
}
