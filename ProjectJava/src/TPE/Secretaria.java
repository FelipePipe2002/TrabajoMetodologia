package TPE;
import java.util.ArrayList;

import TPE.CriterioTurnos.CriterioTurnos;

public class Secretaria extends Usuario {
	private String nombreUsuario;
	private String contrasenia;
	private ArrayList<Medico> medicos;
	
	public Secretaria(String nombre, String apellido, String dni, String nombreUsuario, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.medicos = new ArrayList<>();
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

	public ArrayList<Medico> getMedicos() {
		ArrayList<Medico> aux = new ArrayList<>(this.medicos);
		return aux;
	}

	public void addMedico(Medico medico) {
		if (!this.medicos.contains(medico))
			this.medicos.add(medico);
	}
	
	private String devolverDniMedicos() {
		String aux = new String();
		for (int i = 0; i < this.medicos.size(); i++) {
			if (i == this.medicos.size() - 1)
				aux += this.medicos.get(i).getDni();
			else 
				aux += this.medicos.get(i).getDni() + " ";
		}
		return aux;
	}
	
	public ArrayList<Turno> devolverTurnosDeMedicos(CriterioTurnos c) {
 		ArrayList<Turno> turnosDeMedicos = new ArrayList<Turno>();
 		for (Medico m: this.medicos) {
			for (Turno t : m.getTurnosDisponibles()) {
				if (t.cumple(c))
					turnosDeMedicos.add(t);
			}
		}
		
		return turnosDeMedicos;	
	}
	
//	public void sacarTurnoAPaciente(Clinica c) {
//		Paciente usuario = null;
//		//Login.loguearPaciente(usuario, c);
//		usuario.seleccionarTurno(usuario.devolverTurnosPorFiltro(c, c.filtrarMedicos(this.medicos)));
//	}

	@Override
	public String toString() {
		return super.toString() + "," + nombreUsuario + "," + contrasenia + "," + devolverDniMedicos();
	}
	
	
}
