package esercizio.models;

public class RisorseUmane extends Dipendente {
	
	private String mansione;
	
	public RisorseUmane(String nome, String cognome, String dob, String email, String numTel, String ruolo, boolean tester, String mansione) {
		super(nome, cognome, dob, email, numTel, ruolo, tester);
		this.mansione = mansione;
	}
	
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	
	public String getMansione() {
		return mansione;
	}
	
	@Override
	public String toString() {
		return ("Nome: "+ this.getNome() + "\tCognome: "+ this.getCognome() + "\tData di nascita: " + this.getDob()  + "\tEmail: " + this.getEmail() + "\tNumero Telefonico: " + this.getNumTel() + "\truolo: " + this.getRuolo() + "\tMansione: " + this.getMansione() + this.getTester());
	}
	
}
