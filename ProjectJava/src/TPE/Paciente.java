package TPE;

import java.time.LocalDateTime;
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
		turno.asignarPaciente(this);
	}
	
	public void eliminarTurno(Turno turno) {
		this.turnos.remove(turno);
		turno.setDisponible(true);
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}
	
	private void setDepto(String depto) {
		this.direccion.setDepto(depto);
	}

	private void setPiso(String piso) {
		this.direccion.setPiso(piso);
	}

	private void setNroCalle(String nro_calle) {
		this.direccion.setNumero(nro_calle);;
	}

	private void setCalle(String calle) {
		this.direccion.setCalle(calle);
		
	}
	

	@Override
	public String toString() {
		return  super.toString() + "," + direccion.toString() + "," + telefono + "," + email + "," + obraSocial + "," + nroAfiliado;
	}
	
}