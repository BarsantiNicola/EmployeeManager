package esercizio.models;

public class Tester extends Dipendente {

	private String reparto;
	private short IDTeam;

	public Tester(String nome, String cognome, String dob, String email, String numTel, String ruolo, String reparto,
			short IDTeam, boolean tester) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.reparto = reparto;
		this.IDTeam = IDTeam;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public String getReparto() {
		return reparto;
	}

	public void setIDTeam(short IDTeam) {
		this.IDTeam = IDTeam;
	}

	public short getIDTeam() {
		return IDTeam;
	}

	public String toString() {
		return ("Name: " + this.getNome() + "\tSurname: " + this.getCognome() + "\tDate of birth: " + this.getDob()
				+ "\tEmail: " + this.getEmail() + "\tPhone number: " + this.getNumTel() + "\tOccupation: "
				+ this.getRuolo() + "\tDepartment: " + this.getReparto() + "\tTeam ID: " + this.getIDTeam() 
				+ "\tTester: " + this.getTester());
	}

}
