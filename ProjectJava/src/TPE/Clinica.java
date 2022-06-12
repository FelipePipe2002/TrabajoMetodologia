package TPE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import TPE.FiltroMedico.*;
import TPE.CriterioTurnos.*;

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
	
	public ArrayList<Medico> filtrarMedicos(){
		FiltroDeBusqueda filtro;
		
		Scanner read = new Scanner(System.in);  
		
		String especialidad;
		String obrasocial;
		
		System.out.println("Cargue las opciones de busqueda");
		
		System.out.println("Cargue especialidad si quiere buscar por especialidad:");
		especialidad = read.nextLine();
		
		System.out.println("Cargue especialidad si quiere buscar por Obra Social:");
		obrasocial = read.nextLine();
		
		if (obrasocial == "" && especialidad != "")
			filtro = new FiltroPorEspecialidad(especialidad);
		else if (obrasocial != "" && especialidad == "")
			filtro = new FiltroPorObraSocial(obrasocial);
		else {
			FiltroDeBusqueda filtroe = new FiltroPorEspecialidad(especialidad);
			FiltroDeBusqueda filtroo = new FiltroPorObraSocial(obrasocial);
			filtro = new FiltroDeBusquedaAnd(filtroe,filtroo);
		}
		return buscarMedicos(filtro);
	}
	
	public ArrayList<Medico> filtrarMedicos(ArrayList<Medico> medicos_disponibles){	//Para los medicos con los que trabaja la secretaria
		
		FiltroDeBusqueda filtro = new FiltroPorMedico(medicos_disponibles);
		
		Scanner read = new Scanner(System.in);  
		
		String especialidad;
		String obrasocial;
		
		System.out.println("Cargue las opciones de busqueda");
		
		System.out.println("Cargue especialidad si quiere buscar por especialidad:");
		especialidad = read.nextLine();
		
		System.out.println("Cargue especialidad si quiere buscar por Obra Social:");
		obrasocial = read.nextLine();
		
		if (obrasocial == "" && especialidad != "")
			filtro = new FiltroDeBusquedaAnd(filtro, new FiltroPorEspecialidad(especialidad));
		else if (obrasocial != "" && especialidad == "")
			filtro = new FiltroDeBusquedaAnd(filtro, new FiltroPorObraSocial(especialidad));
		else {
			FiltroDeBusqueda filtroe = new FiltroPorEspecialidad(especialidad);
			FiltroDeBusqueda filtroo = new FiltroPorObraSocial(obrasocial);
			FiltroDeBusqueda aux = new FiltroDeBusquedaAnd(filtroe,filtroo);
			filtro = new FiltroDeBusquedaAnd(filtro, aux);
		}
		
	
		return buscarMedicos(filtro);
	}
		
	public ArrayList<String> listarEspecialidades(){
		
		ArrayList<String> lista = new ArrayList<>();
		
		for (Medico m: this.medicos){
			lista.addAll(m.getEspecialidades());
		}
		
		Set<String> sinRepetir = new HashSet<String>(lista);
		lista.clear();
		lista.addAll(sinRepetir);
		
		return lista;
	}
	
	public ArrayList<String> listarObraSocial(){
		ArrayList<String> lista = new ArrayList<>();

		for (Medico m: this.medicos){
			lista.addAll(m.getObrasSociales());
		}
		
		Set<String> sinRepetir = new HashSet<String>(lista);
		lista.clear();
		lista.addAll(sinRepetir);
		
		return lista;
	}
	
 	public ArrayList<Turno> devolverTurnosMedico(Medico m) {
		Scanner read = new Scanner(System.in);  
		
		String opcion;
		
		System.out.println("Quiere filtrar turno por rango de fechas? s/n");
		opcion = read.nextLine();
		
		CriterioTurnos CriterioGeneral = new CriterioTurnosVerdadero();
		
		if (opcion == "s") {
			System.out.println("Cargue Primera fecha (aaaa-mm-dd) -> ej(2001-01-01): ");
			String FechaInis = read.nextLine();
			LocalDateTime FechaIni = LocalDateTime.of(Integer.parseInt(FechaInis.substring(0, 3)),Integer.parseInt(FechaInis.substring(5, 6)),Integer.parseInt(FechaInis.substring(8, 9)),0,0);
			
			System.out.println("Cargue Segunda fecha (aaaa-mm-dd) -> ej(2001-01-01): ");
			String FechaFinals = read.nextLine();
			LocalDateTime FechaFinal = LocalDateTime.of(Integer.parseInt(FechaFinals.substring(0, 3)),Integer.parseInt(FechaFinals.substring(5, 6)),Integer.parseInt(FechaFinals.substring(8, 9)),0,0);
			
			while (FechaFinal.compareTo(FechaIni)<0) {
				System.out.println("Cargue Segunda fecha mayor que la primera (aaaa-mm-dd) -> ej(2001-01-01): ");
				FechaFinals = read.nextLine();
				FechaFinal = LocalDateTime.of(Integer.parseInt(FechaFinals.substring(0, 3)),Integer.parseInt(FechaFinals.substring(5, 6)),Integer.parseInt(FechaFinals.substring(8, 9)),0,0);
			}
			
			System.out.println("Quiere filtrar turno por mañana o tarde? s/n");
			String turnomt = read.nextLine();
			
			if (turnomt == "s") {
				System.out.println("A que tiempo horario quiere el turno? m/t (mañana/tarde)");
				String horario = read.nextLine();
				
				CriterioTurnos R = new CriterioTurnosRango(FechaIni,FechaFinal);
				CriterioTurnos H;
				if (horario == "t")
					H = new CriterioTurnosNot(new CriterioTurnosManiana());
				else
					H = new CriterioTurnosManiana();
				
				CriterioGeneral = new CriterioTurnosAnd(R,H);
			} else
				CriterioGeneral = new CriterioTurnosRango(FechaIni,FechaFinal);
		}
		

		ArrayList<Turno> turnosmedico = m.getTurnos();
		for (Turno t : turnosmedico) {
			if (t.cumple(CriterioGeneral))
				turnosmedico.add(t);
		}
		
		return turnosmedico;	
	}
}
