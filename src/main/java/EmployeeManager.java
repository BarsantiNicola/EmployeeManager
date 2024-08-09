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
					risultato = (HashMap<String, Dipendente>)Operazioni.getOrganico().clone();
					while (check.toLowerCase().equals("sì") || check.toLowerCase().equals("si")) {
						System.out.println(
								"Type the attribute in order to search among:\n Name\t\tSurname\t\tDate of birth\t\tEmail\t\tPhone number\t\tOccupation\t\tDepartment\t\tTeam ID\t\tResponsibility\t\tLanguage\t\tTask\t\tTester\n");
						String query = scan.nextLine();
						prevRisultato = (HashMap<String, Dipendente>)risultato.clone();
						risultato = (HashMap<String, Dipendente>)Operazioni.Search(query, prevRisultato).clone();
						System.out.print("Keep searching?\t");
						check = new String(scan.nextLine());
						Operazioni.clearConsole();
					}
					for(Dipendente dip : risultato.values()) {
						System.out.println (dip.toString());							
					}
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
