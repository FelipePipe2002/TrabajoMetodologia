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

	@Override
	public String toString() {
		return calle + "," + numero + "," + piso + "," + depto;
	}
	
	
}