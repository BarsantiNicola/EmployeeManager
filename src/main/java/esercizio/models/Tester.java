package esercizio.models;

public class Tester extends Dipendente {
	
	private String reparto;
	private short IDTeam;
	
	public Tester(String nome, String cognome, String dob, String email, String numTel, String ruolo, boolean tester, String reparto, short IDTeam) {
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
	
}
