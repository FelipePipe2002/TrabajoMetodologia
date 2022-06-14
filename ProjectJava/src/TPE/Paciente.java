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
		turno.asignarPaciente(this);
	}
	
	public void eliminarTurno(Turno turno) {
		this.turnos.remove(turno);
		turno.setDisponible(true);
	}
	
//	public ArrayList<Turno> devolverTurnosPorFiltro(Clinica c) {
//		
//		ArrayList<Medico> MedicosFiltrados= c.filtrarMedicos();
//		
//		if (MedicosFiltrados.size()<0) {
//			System.out.println("No hay medicos que cumplan esa condicion");
//		} else {
//			System.out.println(MedicosFiltrados);
//			
//			Scanner read = new Scanner(System.in);  
//			String DNI;
//			System.out.println("Cargue el DNI del Medico con el que quiera sacar turno");
//			DNI = read.nextLine();
//			
//			int dni = Integer.parseInt(DNI);
//			Medico Seleccionado = null;
//			for(Medico m: MedicosFiltrados) {
//				if (m.dni.equals(dni))
//					Seleccionado = m;
//			}
//			
//			return c.devolverTurnosMedico(Seleccionado);
//		}
//			
//		return null;		
//	}
	
	public ArrayList<Turno> devolverTurnosPorFiltro(Clinica c, ArrayList<Medico> medicos) {	//Con algunos medicos predefinidos
		
		ArrayList<Medico> MedicosFiltrados= c.filtrarMedicos(medicos);
		
		if (MedicosFiltrados.size()<0) {
			System.out.println("No hay medicos que cumplan esa condicion");
		} else {
			System.out.println(MedicosFiltrados);
			
			Scanner read = new Scanner(System.in);  
			String dni;
			System.out.println("Cargue el DNI del Medico con el que quiera sacar turno");
			dni = read.nextLine();
			
			Medico Seleccionado = null;
			for(Medico m: MedicosFiltrados) {
				if (m.dni.equals(dni))
					Seleccionado = m;
			}
			
			return c.devolverTurnosMedico(Seleccionado);
		}
			
		return null;		
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
	
//	private void reconfirmarDatos() {
//		System.out.println(this);
//		System.out.println("Estos datos son correctos?");
//		System.out.println("1. Si");
//		System.out.println("2. No");
//		Scanner read = new Scanner(System.in);
//		
//		if (Integer.parseInt(read.nextLine()) == 2){
//			System.out.println("Indique que quiere modificar");
//			System.out.println("1. Nombre");
//			System.out.println("2. Apellido");
//			System.out.println("3. DNI");
//			System.out.println("4. Calle");
//			System.out.println("5. Numero de calle");
//			System.out.println("6. Piso");
//			System.out.println("7. Depto");
//			System.out.println("8. Telefono");
//			System.out.println("9. Email");
//			System.out.println("10. Obra Social");
//			System.out.println("11. Numero de afiliado");
//			Scanner error = new Scanner(System.in);
//			Scanner corregir = new Scanner(System.in);  ;
//			switch(error.nextLine()){
//				case "1":{
//					System.out.print(" >>> Por favor, ingrese su nombre: ");
//					String nuevoNombre = corregir.nextLine();
//					this.setNombre(nuevoNombre);
//					break;
//				}
//				case "2":{
//					System.out.print(" >>> Por favor, ingrese su apellido: ");
//					String nuevoApellido = corregir.nextLine();
//					this.setApellido(nuevoApellido);
//					break;
//				}
//				case "3":{
//					System.out.print(" >>> Por favor, ingrese su dni: ");
//					String dni = corregir.nextLine();
//					this.setDni(dni);
//					break;
//				}
//				case "4":{
//					System.out.print(" >>> Por favor, ingrese su calle: ");
//					String calle = corregir.nextLine();
//					this.setCalle(calle);
//					break;
//				}
//				case "5":{
//					System.out.print(" >>> Por favor, ingrese su numero de calle: ");
//					String nro_calle = corregir.nextLine();
//					this.setNroCalle(nro_calle);
//					break;
//				}
//				case "6":{
//					System.out.print(" >>> Por favor, ingrese su piso: ");
//					String piso = corregir.nextLine();
//					this.setPiso(piso);
//					break;
//				}
//				case "7":{
//					System.out.print(" >>> Por favor, ingrese su depto: ");
//					String depto = corregir.nextLine();
//					this.setDepto(depto);
//					break;
//				}
//				case "8":{
//					System.out.print(" >>> Por favor, ingrese su telefono: ");
//					String telefono = corregir.nextLine();
//					if(Login.verificarCampoNotificacion(telefono, ""))
//						this.setTelefono(telefono);
//					break;
//				}
//				case "9":{
//					System.out.print(" >>> Por favor, ingrese su email: ");
//					String email = corregir.nextLine();
//					if(Login.verificarCampoNotificacion("", email))
//						this.setEmail(email);
//					break;
//				}
//				case "10":{
//					System.out.print(" >>> Por favor, ingrese su obra social: ");
//					String obra_soc = corregir.nextLine();
//					this.setObraSocial(obra_soc);
//					break;
//				}
//				case "11":{
//					System.out.print(" >>> Por favor, ingrese su numero de afiliado: ");
//					String nro_afiliado = corregir.nextLine();
//					this.setNroAfiliado(nro_afiliado);
//					break;
//				}
//				default:{
//					System.out.println("Se ingreso un numero no valido");
//					reconfirmarDatos();
//				}
//			}
//		}else if((Integer.parseInt(read.nextLine()) != 1)) {
//			System.out.println("Se ingreso un numero no valido");
//			reconfirmarDatos();
//		}
//	}
	
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

//	private boolean confirmarTurno(Turno elegido) {
//		if(!elegido.getMedico().getObrasSociales().contains(this.getObraSocial()))
//			System.out.println("Tenga en cuenta de que el doctor" + elegido.getMedico().getApellido() + " no trabaja con " + this.getObraSocial());
//		System.out.println("Usted eligio el turno " + elegido);
//		System.out.println("Desea confirmarlo?");
//		System.out.println("1. Si");
//		System.out.println("2. No");
//		Scanner read = new Scanner(System.in);
//		
//		if(Integer.parseInt(read.nextLine()) == 1) {
//			reconfirmarDatos();
//			return true;
//		}else
//			return false;
//	}
	

	public void seleccionarTurno(ArrayList<Turno> turnos) {
		if(!turnos.isEmpty()) {
			System.out.println(turnos);
			System.out.print("Seleccione turno: ");
			Scanner index = new Scanner(System.in);
			
			Turno t = turnos.get(Integer.parseInt(index.nextLine()));
			
			if(confirmarTurno(t)) {
				System.out.println("Hola");
				t.asignarPaciente(this);
				this.addTurno(t);
				
				String doctor = "Dr. " + t.getMedico().getApellido() + " " + t.getMedico().getApellido() ;
				String paciente = this.getApellido() + " " + this.getNombre();
				
				//Enviar mail de confirmacion al paciente
				if( Login.verificarCampoNotificacion("", email) ) {
			 
					String subject = "  �Confirmado! Turno con " + doctor ;
					String msg = " El turno de " + paciente + " con " + doctor + " est� confirmado " + '\n';
						   msg += "Los datos del turno son " + t.getFecha() + '\n';
						   msg += "�Necesit�s cancelar el turno? Por favor hacerlo con anticipacion.";
					SendEmail.send(this.getEmail(), subject, msg);
				}
				//else
					//Futura implementacion de enviar por telefono
	
				
			} else
				System.out.println("No se reservo ningun turno");
		}		
	}


	@Override
	public String toString() {
		return  super.toString() + "," + direccion.toString() + "," + telefono + "," + email + "," + obraSocial + "," + nroAfiliado;
	}
	
}