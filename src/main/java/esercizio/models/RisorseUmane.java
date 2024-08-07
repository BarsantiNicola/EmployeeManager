package esercizio.models;

public class RisorseUmane extends Dipendente {
	
	private String mansione;
	
	public RisorseUmane(String nome, String cognome, String dob, String email, String numTel, String ruolo, boolean tester, String mansione) {
		this.mansione = mansione;
	}
	
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	
	public String getMansione() {
		return mansione;
	}
	
	
}
