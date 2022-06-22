package TPE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import TPE.FiltroMedico.*;
import TPE.CriterioTurnos.*;

public class Clinica {
	private String nombre;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Secretaria> secretarias;

	public Clinica(String nombre) {
		this.nombre = nombre;
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
	
	public String getNombre() {
		return this.nombre;
	}

	public Paciente getPaciente(String dni) {
		for (int i=0; i < this.pacientes.size(); i++) {
			if (this.pacientes.get(i).getDni().equals(dni))
				return this.pacientes.get(i);
		}
		return null;
	}

	public ArrayList<Medico> getMedicos() {
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
		
	public ArrayList<Secretaria> getSecretarias() {
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
	
	public ArrayList<Medico> filtrarMedicos(String especialidad, String obraSocial){
		
		FiltroDeBusqueda filtro;
		if (obraSocial == "" && especialidad == "") {
			return new ArrayList<>(this.medicos);
		}
		if (obraSocial == "" && especialidad != "")
			filtro = new FiltroPorEspecialidad(especialidad);
		else if (obraSocial != "" && especialidad == "")
			filtro = new FiltroPorObraSocial(obraSocial);
		else {
			FiltroDeBusqueda filtro1 = new FiltroPorEspecialidad(especialidad);
			FiltroDeBusqueda filtro2 = new FiltroPorObraSocial(obraSocial);
			filtro = new FiltroDeBusquedaAnd(filtro1,filtro2);
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
		
	public String[] listarEspecialidades(){
		
		ArrayList<String> aux = new ArrayList<>();
		aux.add("");
		for (Medico m: this.medicos){
			aux.addAll(m.getEspecialidades());
		}
		
		Set<String> sinRepetir = new HashSet<String>(aux);
		aux.clear();
		aux.addAll(sinRepetir);
		
		String[] lista = new String[aux.size()];
		lista = aux.toArray(lista);
		
		return lista;
	}
	
	public String[] listarObraSocial(){
		
		ArrayList<String> aux = new ArrayList<>();
		aux.add("");
		for (Medico m: this.medicos){
			aux.addAll(m.getObrasSociales());
		}
		
		Set<String> sinRepetir = new HashSet<String>(aux);
		aux.clear();
		aux.addAll(sinRepetir);
		
		String[] lista = new String[aux.size()];
		lista = aux.toArray(lista);
		
		return lista;
	}
	
 	public ArrayList<Turno> devolverTurnosMedico(Medico m,CriterioTurnos c) {
 		ArrayList<Turno> turnosmedico = new ArrayList<Turno>();
 		ArrayList<Turno> aux = m.getTurnos();
		for (Turno t : aux) {
			if (t.cumple(c) && t.getdisponible())
				turnosmedico.add(t);
		}
		
		return turnosmedico;	
	}
}
