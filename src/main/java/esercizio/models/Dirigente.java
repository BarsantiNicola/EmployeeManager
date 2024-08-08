package esercizio.models;

public class Dirigente extends Dipendente {

	private String reparto;
	private short IDTeam;
	private byte responsabilita;

	public Dirigente(String nome, String cognome, String dob, String email, String numTel, String ruolo, boolean tester, String reparto, short IDTeam, byte responsabilita) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.reparto = reparto;
		this.IDTeam = IDTeam;
		this.responsabilita = responsabilita;
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

	public void setResponsabilita(byte responsabilita) {
		this.responsabilita = responsabilita;
	}

	public byte getResponsabilita() {
		return responsabilita;
	}

	@Override
	public String toString() {
		return ("Nome: " + this.getNome() + "\tCognome: " + this.getCognome() + "\tData di nascita: " + this.getDob() + "\tEmail: " + this.getEmail() + "\tNumero Telefonico: " + this.getNumTel() + "\truolo: " + this.getRuolo() + "\treparto: " + this.getReparto() + "\tTeam: " + this.getIDTeam() + "\tResponsabilità: " + this.getResponsabilita() + getTester());
	}

}
