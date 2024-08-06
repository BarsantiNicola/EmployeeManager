
public class Dipendente {
	
	private String nome;
	private String cognome;
	private String dob;
	private String email;
	private String numTel;
	
	public Dipendente() {
		
	}
	
	public Dipendente(String nome, String cognome, String dob, String email, String numTel) {
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.email = email;
		this.numTel = numTel;
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
	
	public String dettagli() {
		return ("Nome: "+ this.getNome() + "\tCognome: "+ this.getCognome() + "\tData di nascita: " + this.getDob()  + "\tEmail: " + this.getEmail() + "\tNumero Telefonico" + this.getNumTel());
	}
}
