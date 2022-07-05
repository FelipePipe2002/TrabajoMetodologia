package TPE;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medico extends Usuario{
	private String nombreUsuario;
	private String contrasenia;
	private ArrayList<String> especialidades;
	private ArrayList<String> obrasSociales;
	private ArrayList<Turno> turnos;
	private String DiasDeLaburo;
	private LocalDateTime HoraDeInicio;
	private LocalDateTime HoraDeCierre;
	private LocalDateTime DuracionDeTurno;
	
	public Medico(String nombre, String apellido, String dni, String nombreUsuario, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.especialidades = new ArrayList<>();
		this.obrasSociales = new ArrayList<>();
		this.turnos = new ArrayList<>();
		this.DiasDeLaburo = null;
		this.HoraDeInicio = null;
		this.HoraDeCierre = null;
		this.DuracionDeTurno = null;
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
	
	public String getDiasDeLaburo() {
		return DiasDeLaburo;
	}

	public void setDiasDeLaburo(String diasDeLaburo) {
		DiasDeLaburo = diasDeLaburo;
	}

	public LocalDateTime getHoraDeInicio() {
		LocalDateTime aux = LocalDateTime.of(0,1,1,this.HoraDeInicio.getHour(),this.HoraDeInicio.getMinute());
		return aux;
	}

	public void setHoraDeInicio(LocalDateTime horaDeInicio) {
		HoraDeInicio = LocalDateTime.of(0,1,1,horaDeInicio.getHour(),horaDeInicio.getMinute());
	}

	public LocalDateTime getHoraDeCierre() {
		LocalDateTime aux = LocalDateTime.of(0,1,1,this.HoraDeCierre.getHour(),this.HoraDeCierre.getMinute());
		return aux;
	}

	public void setHoraDeCierre(LocalDateTime horaDeCierre) {
		HoraDeCierre =  LocalDateTime.of(0,1,1,horaDeCierre.getHour(),horaDeCierre.getMinute());
	}

	public LocalDateTime getDuracionDeTurno() {
		LocalDateTime aux = LocalDateTime.of(0,1,1,this.DuracionDeTurno.getHour(),this.DuracionDeTurno.getMinute());
		return aux;
	}

	public void setDuracionDeTurno(LocalDateTime duracionDeTurno) {
		DuracionDeTurno = LocalDateTime.of(0,1,1,duracionDeTurno.getHour(),duracionDeTurno.getMinute());
	}

	public Turno getTurno(LocalDateTime fecha) {
		for (Turno turno:this.turnos) {
			if (turno.getFecha().equals(fecha))
				return turno;
		}
		return null;
	}
	
	public ArrayList<Turno> getTurnos() {
		ArrayList<Turno> aux = new ArrayList<>(this.turnos);
		return aux;
	}
	
	public ArrayList<Turno> getTurnosDisponibles() {
		ArrayList<Turno> aux = new ArrayList<>();
		for (Turno turno:this.turnos) {
			if (turno.isDisponible() && turno.getFecha().isAfter(LocalDateTime.now()))
				aux.add(turno);
		}
		return aux;
	}
	
	public ArrayList<String> getEspecialidades() {
		ArrayList<String> aux = new ArrayList<>(this.especialidades);
		return aux;
	}
	
	public ArrayList<String> getObrasSociales() {
		ArrayList<String> aux = new ArrayList<>(this.obrasSociales);
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
		return  super.toString() + "," + nombreUsuario + "," + contrasenia + "," + devolverEspecialidades() + "," + devolverObrasSociales() + "," + getDiasDeLaburo() + "," + getHoraDeInicio() + "," + getHoraDeCierre() + "," + getDuracionDeTurno();
	}
	
	
}
