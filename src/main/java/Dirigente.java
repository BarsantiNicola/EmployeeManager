
public class Dirigente extends Dipendente{
	
	private String reparto;
	private short IDTeam;
	private byte responsabilita;
	
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
	
}
