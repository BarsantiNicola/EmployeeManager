import java.util.Scanner;

public class EmployeeManager {
	public static void main (String args[]) {
		
		String nome = null;
		String cognome = null;
				
		Dipendente organico[] = new Dipendente[50];
		System.out.println("Available commands:\n - Add Employee(a)\n - Search Employees(s)\n - Update Employee(u)\n - Delete Employee(d)\n - Exit(e)\n\nSelect Command:");		
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine().toLowerCase();
		char c = command.charAt(0);
		
		switch(c) {		
			case 'a':				
				for (int i=0; i < 50; i++) {
					organico[i] = new Dipendente();
					
					if (organico[i].getNome() == null) {
						
						System.out.print("Inserire il nome del dipendente:\t");
						nome = scan.nextLine();
						System.out.print("Inserire il cognome del dipendente:\t");
						cognome = scan.nextLine();
						//break;
					}
				
				
				for(int j=0; j<i ; j++) {
					
					if (nome == organico[j].getNome() & cognome == organico[j].getCognome()) {
						System.out.println("A frocio che cazzo stai a fa");
					} else {
						organico[i].setNome(nome);
						organico[i].setCognome(cognome);
					}
				}
				
				}
									
				break;
			case 's':
				

				
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
