package TPE;

import java.util.ArrayList;

//import java.util.ArrayList;//import java.time.LocalDateTime;
import Interfaz.*;
import TPE.Read.*;
import TPE.Write.*;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = null;

    	Clinica clinica = new Clinica();

    	VentanaLogin login = new VentanaLogin();
    	
		// Inicializacion de archivos
		ReadPacientes pacientes = new ReadPacientes();
		ReadMedico medicos = new ReadMedico();
		ReadSecretaria secretarias = new ReadSecretaria();
		ReadTurnos turnos = new ReadTurnos();

		pacientes.agregarClinica(clinica); //lee el archivo que guarda la info. de pacientes
		medicos.agregarClinica(clinica); //lee el archivo que guarda la info. de medicos
		secretarias.agregarClinica(clinica); //lee el archivo que guarda la info. de secretarias
		turnos.agregarClinica(clinica); // lee el archivo que guarda la info. de turnos
			
		//Codigo
		System.out.println("Pacientes:");
		System.out.println(clinica.getPacientes());
		System.out.println("Medico:");
		System.out.println(clinica.getMedico());
		System.out.println("Secretaria:");
		System.out.println(clinica.getSecretaria());
		System.out.println("Turnos:");
		System.out.println(clinica.getTurnos());
		login.setVisible(true);
		ArrayList<String> aux = new ArrayList();
		aux.addAll(clinica.listarObraSocial());
		System.out.println(aux);
		// Logueo de usuario
		Login.loguear(usuario, clinica);
		
		//Guardado de datos
		WriteCSV archivoPacientes = new WritePacientes(clinica);
		archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
		WriteCSV archivoMedicos = new WriteMedicos(clinica);
		archivoMedicos.generarArchivoCSV(medicos.getCsvFile());
		WriteCSV archivoSecretarias = new WriteSecretarias(clinica);
		archivoSecretarias.generarArchivoCSV(secretarias.getCsvFile());
		WriteCSV archivoTurnos = new WriteTurnos(clinica);
		archivoTurnos.generarArchivoCSV(turnos.getCsvFile());

	}
}
