import java.util.Scanner;
import java.util.HashMap;

public class EmployeeManager {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);		
		HashMap<String, Dipendente> organico = new HashMap<String, Dipendente>();		
		char c = ' ';
		Dipendente init = new Dipendente("nome", "cognome", "6/9/98", "indirizzo@dominio.com", "123", "Dirigente", true);
		String chiave = init.getNome().toLowerCase()+" "+init.getCognome().toLowerCase();
		organico.put(chiave, init);
				
	while(c != 'e') {
			
		System.out.println("Available commands:\n - Add Employee(a)\n - Search Employees(s)\n - Update Employee(u)\n - Delete Employee(d)\n - Exit(e)\n\nSelect Command:");
		String command = scan.nextLine().toLowerCase();
		c = command.charAt(0);
		
		switch(c) {		
			case 'a':
				
				System.out.print("Inserire il nome del dipendente:\t");
				String nome = new String (scan.nextLine());
				System.out.print("Inserire il cognome del dipendente:\t");
				String cognome = new String (scan.nextLine());
								
				
				if (organico.containsKey(nome.toLowerCase() + " " + cognome.toLowerCase())) {
					System.out.println("Dipendente già presente");
					break;
				} else {
					System.out.println("Nuovo dipendente!\t");
					System.out.print("Inserire la data di nascita:\t");
					String dob = new String(scan.nextLine());
					System.out.print("Inserire l'indirizzo email:\t");
					String email = new String (scan.nextLine());
					System.out.print("Inserire il numero di telefono:\t");
					String tel = new String (scan.nextLine());
					System.out.print("Inserire la mansione:\t");
					String mansione = new String (scan.nextLine());
					System.out.print("Specificare se è un tester (sì/no):\t");
					String t = new String (scan.nextLine());
					boolean tester = false;
					if (t.toLowerCase().equals("sì") || t.toLowerCase().equals("si"))  tester = true;					
					Dipendente temp = new Dipendente(nome, cognome, dob, email, tel, mansione, tester);
					organico.put(nome.toLowerCase() + " " + cognome.toLowerCase(), temp);
					clearConsole();
					break;
				}
			case 's':
				
				if (organico.isEmpty()) {
					clearConsole();
					System.out.println("La lista è vuota");
					break;
				}
				
				System.out.println("Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico\t\tMansione");
				String query = scan.nextLine();
				
				switch (query.toLowerCase()){
					
					case "nome":
						System.out.print("Digitare il nome:\t");
						String name = scan.nextLine();
						for (Dipendente dip : organico.values()) {
	                        if (dip.getNome().toLowerCase().equals(name.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					case "cognome":
						System.out.print("Digitare il cognome:\t");
						String surname = scan.nextLine();						
						for (Dipendente dip : organico.values()) {
	                        if (dip.getCognome().toLowerCase().equals(surname.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					case "data di nascita":
						System.out.print("Digitare la data di nascita (gg/mm/yy):\t");
						String dob = scan.nextLine();
						for (Dipendente dip : organico.values()) {
	                        if (dip.getDob().toLowerCase().equals(dob.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					case "email":
						System.out.print("Digitare l'indirizzo email:\t");
						String email = scan.nextLine();						
						for (Dipendente dip : organico.values()) {
	                        if (dip.getEmail().toLowerCase().equals(email.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					case "numero telefonico":
						System.out.print("Digitare il numero telefonico:\t");
						String num = scan.nextLine();						
						for (Dipendente dip : organico.values()) {
	                        if (dip.getNumTel().toLowerCase().equals(num.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					case "mansione":
						System.out.print("Digitare la mansione:\t");
						String mansione = scan.nextLine();						
						for (Dipendente dip : organico.values()) {
	                        if (dip.getMansione().toLowerCase().equals(mansione.toLowerCase())) {
	                        	stampaInformazioni(dip);
	                        } else clearConsole();
						}
						break;
					default: 
						clearConsole();
						System.out.println("Input non corretto, riprovare");
				}
			case 'u':
				

				
				break;
			case 'd':
				
				System.out.print("Digitare il nome e il cognome del dipendente da eliminare separati da uno spazio:\t");
				String key = scan.nextLine().toLowerCase();				
				if (organico.containsKey(key)) {
					organico.remove(key);
					clearConsole();
					break;
				} else System.out.println("Il dipendente non esiste");
				break;
			case 'e':
				break;
				
			default:
				clearConsole();
				System.out.println("Input non corretto, riprovare");
		}
	}	
} //FINE MAIN
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

