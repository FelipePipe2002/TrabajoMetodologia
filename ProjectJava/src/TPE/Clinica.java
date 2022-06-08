package TPE;
import java.util.ArrayList;

public class Clinica {
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Secretaria> secretarias;

	public Clinica() {
		this.pacientes = new ArrayList<>();
		this.medicos = new ArrayList<>();
		this.secretarias = new ArrayList<>();
	}
	
	public void addPaciente(Paciente paciente) {
		if(!pacientes.contains(paciente))
			this.pacientes.add(paciente);
	}
	
	public void addMedico(Medico medico) {
		if(!medicos.contains(medico))
				this.medicos.add(medico);
	}
	
	public void addSecretaria(Secretaria secretaria) {
		if(!secretarias.contains(secretaria))
			this.secretarias.add(secretaria);
	}
	
	public ArrayList<Paciente> getPacientes() {
		ArrayList<Paciente> aux = new ArrayList<>(this.pacientes);
		return aux;
	}
	
	public Paciente getPaciente(String dni) {
		for (int i=0; i < this.pacientes.size(); i++) {
			if (this.pacientes.get(i).getDni().equals(dni))
				return this.pacientes.get(i);
		}
		return null;
	}

	public ArrayList<Medico> getMedico() {
		ArrayList<Medico> aux = new ArrayList<>(this.medicos);
		return aux;
	}

	public Medico getMedico(String dni) {
		for (int i=0; i < this.medicos.size(); i++) {
			if (this.medicos.get(i).getDni().equals(dni))
				return this.medicos.get(i);
		}
		return null;
	}
		
	public ArrayList<Secretaria> getSecretaria() {
		ArrayList<Secretaria> aux = new ArrayList<>(this.secretarias);
		return aux;
		
	}
	
	public Secretaria getSecretaria(String dni) {
		for (int i=0; i < this.secretarias.size(); i++) {
			if (this.secretarias.get(i).getDni().equals(dni))
				return this.secretarias.get(i);
		}
		return null;
	}
	
	public ArrayList<Turno> getTurnos() {
		ArrayList<Turno> aux = new ArrayList<>();
		for (Medico m:medicos) {
			aux.addAll(m.getTurnos());
		}
		return aux;
	}
	
	public ArrayList<Medico> buscarMedicos(FiltroDeBusqueda filtro) {
		ArrayList<Medico> aux = new ArrayList<>();
		for (Medico m:medicos) {
			if(filtro.filtrar(m))
				aux.add(m);
		}
		return aux;
	}
	
}