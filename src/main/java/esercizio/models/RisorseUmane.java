package esercizio.models;

public class RisorseUmane extends Dipendente {

	private String mansione;
	private String reparto;
	private short IDTeam;

	public RisorseUmane() {

	}

	public RisorseUmane(String nome, String cognome, String dob, String email, String numTel, String ruolo,
			String mansione, String reparto, short IDTeam, boolean tester) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.mansione = mansione;
		this.reparto = reparto;
		this.IDTeam = IDTeam;
	}

	public RisorseUmane(String nome, String cognome, String dob, String email, String numTel, String ruolo,
			String mansione, boolean tester) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.mansione = mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public String getMansione() {
		return mansione;
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

	@Override
	public String toString() {
		if (getTester()) {
			return ("Name: " + this.getNome() + "\tSurname: " + this.getCognome() + "\tDate of birth: " + this.getDob()
					+ "\tEmail: " + this.getEmail() + "\tPhone number: " + this.getNumTel() + "\tOccupation: "
					+ this.getRuolo() + "\tTask: " + this.getMansione() + "\tDepartment:  " + this.getReparto()
					+ "\tTeam ID: " + this.getIDTeam() + "\tTester: " + this.getTester());
		} else
			return ("Name: " + this.getNome() + "\tSurname: " + this.getCognome() + "\tDate of birth: " + this.getDob()
					+ "\tEmail: " + this.getEmail() + "\tPhone number: " + this.getNumTel() + "\tOccupation: "
					+ this.getRuolo() + "\tTask: " + this.getMansione() + "\tTester: " + this.getTester());
	}

}
