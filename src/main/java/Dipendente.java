import java.util.Date;

public class Dipendente {
	
	private String nome;
	private String cognome;
	private Date dob;
	private String email;
	private String numTel;
	
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
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Date getDob() {
		return dob;
	}
}
