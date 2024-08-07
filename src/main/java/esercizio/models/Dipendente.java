package esercizio.models;

public class Dipendente {
	
	private String nome;
	private String cognome;
	private String dob;
	private String email;
	private String numTel;
	private String ruolo;
	private boolean tester;
	
	public Dipendente() {
		
	}
	
	public Dipendente(String nome, String cognome, String dob, String email, String numTel, String ruolo, boolean tester) {
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.email = email;
		this.numTel = numTel;
		this.ruolo = ruolo;
		this.tester = tester;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	public String getNumTel() {
		return numTel;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	/*
	public void setTester(String tester) {
		this.tester = false;
		if (tester.toLowerCase().equals("sì"))  this.tester = true; 
	}
	*/
	public String getTester() {
		if (this.tester) {
			return ", ed è un tester";
		} else return " ";
	}
	
	public String dettagli() {
		return ("Nome: "+ this.getNome() + "\tCognome: "+ this.getCognome() + "\tData di nascita: " + this.getDob()  + "\tEmail: " + this.getEmail() + "\tNumero Telefonico: " + this.getNumTel() + "\truolo: " + this.getRuolo() + getTester());
	}
}
