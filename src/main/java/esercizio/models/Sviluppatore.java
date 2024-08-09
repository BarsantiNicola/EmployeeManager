package esercizio.models;

public class Sviluppatore extends Dipendente {

	private String reparto;
	private short IDTeam;
	private String linguaggio;

	public Sviluppatore(String nome, String cognome, String dob, String email, String numTel, String ruolo,
			String reparto, short IDTeam, String linguaggio, boolean tester) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.reparto = reparto;
		this.IDTeam = IDTeam;
		this.linguaggio = linguaggio;
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

	public void setLinguaggio(String linguaggio) {
		this.linguaggio = linguaggio;
	}

	public String getLinguaggio() {
		return linguaggio;
	}

	@Override
	public String toString() {
		return ("Name: " + this.getNome() + "\tSurname: " + this.getCognome() + "\tDate of birth: " + this.getDob()
				+ "\tEmail: " + this.getEmail() + "\tPhone number: " + this.getNumTel() + "\tOccupation: "
				+ this.getRuolo() + "\tDepartment: " + this.getReparto() + "\tTeam ID: " + this.getIDTeam()
				+ "\tLanguage: " + this.getLinguaggio() + "\tTester: " + this.getTester());
	}

}
