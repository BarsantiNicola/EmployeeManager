import esercizio.operazioni.*;

import java.util.Scanner;

public class EmployeeManager {
	public static void main(String args[]) {
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
				String search = new String();
				System.out.println(
						"Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tRuolo\t\tReparto\t\tID Team\t\tResponsabilità\t\tLinguaggio\t\tMansione");
				String query = scan.nextLine();
				Operazioni.Search(query, Operazioni.getOrganico());
				while (search.equals("sì") | search.equals("si")) {
					Operazioni.Search(query, Operazioni.getResult());
					System.out.println("Effettuare una nuova ricerca?");
					search = new String(scan.nextLine());
				}
				System.out.println(Operazioni.Search(query, Operazioni.getResult()));
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
