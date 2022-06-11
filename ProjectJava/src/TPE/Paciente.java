package TPE;

import java.util.ArrayList;
import java.util.Scanner;

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

	public void addTurno(Turno turno) {
		this.turnos.add(turno);
	}
	
	public ArrayList<Turno> DevolverTurnosPorFiltro(Clinica c) {
		
		ArrayList<Medico> MedicosFiltrados=c.FiltrarMedicos();
		
		if (MedicosFiltrados.size()<0) {
			System.out.println("No hay medicos que cumplan esa condicion");
		} else {
			System.out.println(MedicosFiltrados);
			
			Scanner read = new Scanner(System.in);  
			String DNI;
			System.out.println("Cargue el DNI del Medico con el que quiera sacar turno");
			DNI = read.nextLine();
			
			int dni = Integer.parseInt(DNI);
			Medico Seleccionado = null;
			for(Medico m: MedicosFiltrados) {
				if (m.dni.equals(dni))
					Seleccionado = m;
			}
			
			return c.DevolverTurnosMedico(Seleccionado);
		}
			
		return null;		
	}
	
	@Override
	public String toString() {
		return  super.toString() + "," + direccion.toString() + "," + telefono + "," + email + "," + obraSocial + "," + nroAfiliado;
	}
	
}