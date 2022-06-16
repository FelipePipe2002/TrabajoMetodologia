package TPE;

public class Direccion {
	private String calle;
	private String numero;
	private String piso;
	private String depto;
	
	public Direccion(String calle, String numero, String piso, String depto) {
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.depto = depto;
	}
	
	public Direccion(String calle, String numero) {
		this.calle = calle;
		this.numero = numero;
		this.piso = null;
		this.depto = null;
	}

	public String getCalle() {
		return calle;
	}

	public String getNumero() {
		return numero;
	}

	public String getPiso() {
		return piso;
	}

	public String getDepto() {
		return depto;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setPiso(String piso) {
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