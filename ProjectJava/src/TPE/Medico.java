import java.util.ArrayList;

public class Medico extends Usuario{
	private String nombreUsuario;
	private String contrasenia;
	private ArrayList<String> especialidades;
	private ArrayList<String> obrasSociales;
	private ArrayList<Turno> turnos;
	
	public Medico(String nombre, String apellido, String dni, String nombreUsuario, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.especialidades = new ArrayList<>();
		this.obrasSociales = new ArrayList<>();
		this.turnos = new ArrayList<>();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public Boolean esContrasenia(String contrasenia) {
		return this.contrasenia.equals(contrasenia);
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void addEspecialidad(String especialidad) {
		if (!especialidades.contains(especialidad))
			this.especialidades.add(especialidad);
	}
	
	public void addObraSocial(String obraSocial) {
		if (!obrasSociales.contains(obraSocial))
			this.obrasSociales.add(obraSocial);
	}

	public ArrayList<Turno> getTurnos() {
		ArrayList<Turno> aux = new ArrayList<>(this.turnos);
		return aux;
	}

	public void addTurno(Turno turno) {
		this.turnos.add(turno);
	}

	private String devolverEspecialidades() {
		String aux = new String();
		for (int i = 0; i < this.especialidades.size(); i++) {
			if (i == this.especialidades.size() - 1)
				aux += this.especialidades.get(i);
			else 
				aux += this.especialidades.get(i) + " ";
		}
		return aux;
	}
	
	private String devolverObrasSociales() {
		String aux = new String();
		for (int i = 0; i < this.obrasSociales.size(); i++) {
			if (i == this.obrasSociales.size() - 1)
				aux += this.obrasSociales.get(i);
			else 
				aux += this.obrasSociales.get(i) + " ";
		}
		return aux;
	}
	
	@Override
	public String toString() {
		return  super.toString() + "," + nombreUsuario + "," + contrasenia + "," + devolverEspecialidades() + "," + devolverObrasSociales();
	}
	
}
