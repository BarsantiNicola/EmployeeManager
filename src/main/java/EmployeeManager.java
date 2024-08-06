import java.util.Scanner;

public class EmployeeManager {
	public static void main (String args[]) {
		
		String nome, cognome;
		Scanner scan = new Scanner(System.in);
		Dipendente organico[] = new Dipendente[50];
		
		
		
		for (int i=0; i < 50; i++) {
			organico[i] = new Dipendente();
		}
		
		organico[0].setNome("nunzio");
		organico[0].setCognome("mannalà");
				
		//while(c != 'e') {
			
			//System.out.println(c);
			System.out.println("Available commands:\n - Add Employee(a)\n - Search Employees(s)\n - Update Employee(u)\n - Delete Employee(d)\n - Exit(e)\n\nSelect Command:");
			String command = scan.nextLine().toLowerCase();
			char c = command.charAt(0);
			System.out.println(c);
		
		switch(c) {		
			case 'a':
				
				System.out.print("Inserire il nome del dipendente:\t");
				nome = scan.nextLine();
				System.out.print("Inserire il cognome del dipendente:\t");
				cognome = scan.nextLine();
				
				for (int i=0; i < 50; i++) {
					if (organico[i].getNome() == null) {
						for (int j=0; j<=i; j++) {
						/*System.out.println(nome + " == " + organico[j].getNome().toLowerCase());
						System.out.println(cognome + " == " + organico[j].getCognome().toLowerCase());
						
						System.out.print("nome == organico["+j+"].getNome(): ");
						System.out.println(nome.toLowerCase() == organico[j].getNome().toLowerCase() );
						System.out.println(organico[j].getNome() == null);
						System.out.print("cognome == organico["+j+"].getCognome(): ");
						System.out.println(cognome.toLowerCase() == organico[j].getCognome().toLowerCase() );
						System.out.print("tutto: ");
						System.out.println(nome.toLowerCase() == organico[j].getNome().toLowerCase() & cognome.toLowerCase() == organico[j].getCognome().toLowerCase());*/
							//nome = organico[j].getNome();
							//cognome = organico[j].getCognome();
							System.out.print(nome + "!=" + organico[j].getNome() + ":\t\t");
							System.out.println(nome != organico[j].getNome() );
							System.out.print(cognome + "!=" + organico[j].getCognome() + ":\t");
							System.out.println(cognome != organico[j].getCognome());
						
							if (nome == organico[j].getNome() & cognome == organico[j].getCognome()) {
								System.out.println("Già registrato");
								break;
							} else {
								System.out.println("Nome registrato con successo al posto " + i + "!");
								organico[i].setNome(nome);
								organico[i].setCognome(cognome);
								break;	
							}
						}
						break;
					}
					
				}
			case 's':
				System.out.println("Immettere l'attributo sul quale fare la ricerca fra:\n Nome\t\tCognome\t\tData di nascita\t\tEmail\t\tNumero telefonico");
				String query = scan.nextLine();
				
				switch (query.toLowerCase()){
					
					case "nome":
						System.out.print("Digitare il nome:\t");
						String name = scan.nextLine();
						for (Dipendente dip : organico) {
							//System.out.println(dip.getNome() == name);
							if (dip.getNome() == name) {
								System.out.print("Ecco il risultato della ricerca: ");
								System.out.println(dip.dettagli());
							} else System.out.println("è tutto rotto"); break;
						}
						break;
					case "cognome":
						System.out.print("Digitare il cognome:\t");
						String surname = scan.nextLine();
						for (Dipendente dip : organico) {
							//System.out.println(dip.getNome() == name);
							if (dip.getCognome() == surname) {
								System.out.print("Ecco il risultato della ricerca: ");
								System.out.println(dip.dettagli());
							}
						}
						break;
					case "data di nascita":
						System.out.print("Digitare la data di nascita:\t");
						String dob = scan.nextLine();
						for (Dipendente dip : organico) {
							//System.out.println(dip.getNome() == name);
							if (dip.getDob() == dob) {
								System.out.print("Ecco il risultato della ricerca: ");
								System.out.println(dip.dettagli());
							}
						}
						break;
					case "email":
						System.out.print("Digitare l'indirizzo email:\t");
						String email = scan.nextLine();
						for (Dipendente dip : organico) {
							//System.out.println(dip.getNome() == name);
							if (dip.getEmail() == email) {
								System.out.print("Ecco il risultato della ricerca: ");
								System.out.println(dip.dettagli());
							}
						}
						break;
					case "numero telefonico":
						System.out.print("Digitare il numero telefonico:\t");
						String num = scan.nextLine();
						for (Dipendente dip : organico) {
							//System.out.println(dip.getNome() == name);
							if (dip.getNumTel() == num) {
								System.out.print("Ecco il risultato della ricerca: ");
								System.out.println(dip.dettagli());
							}
						}
						break;		
				}				
				break;
			case 'u':
				

				
				break;
			case 'd':
				

				
				break;
			case 'e':
				break;	
		}
	}	
}
//}

