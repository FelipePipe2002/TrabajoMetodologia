package TPE;

public class Direccion {
	private String calle;
	private int numero;
	private int piso;
	private String depto;
	
	public Direccion(String calle, String numero, String piso, String depto) {
		this.calle = calle;
		this.numero = Integer.parseInt(numero);
		this.piso = Integer.parseInt(piso);
		this.depto = depto;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public int getPiso() {
		return piso;
	}

	public String getDepto() {
		return depto;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	@Override
	public String toString() {
		return calle + "," + numero + "," + piso + "," + depto;
	}
	
	
}