import java.util.ArrayList;

public class Paciente extends Usuario {
	private Direccion direccion;
	private String telefono;
	private String email;
	private String obraSocial;
	private String nroAfiliado;
	private ArrayList<Turno> turnos;
	
	public Paciente(String nombre, String apellido, String dni, Direccion direccion, String telefono, String email, String obraSocial, String nroAfiliado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.obraSocial = obraSocial;
		this.nroAfiliado = nroAfiliado;
		this.turnos = new ArrayList<Turno>();
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public ArrayList<Turno> getTurnos() {
		ArrayList<Turno> aux = new ArrayList<>(this.turnos);
		return aux;
	}

	@Override
	public String toString() {
		return  super.toString() + "," + direccion.toString() + "," + telefono + "," + email + "," + obraSocial + "," + nroAfiliado;
	}
	
}