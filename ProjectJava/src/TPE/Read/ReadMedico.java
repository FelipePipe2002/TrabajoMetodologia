package TPE.Read;

import java.time.LocalDateTime;

import TPE.*;

public class ReadMedico extends ReadCSV{
	public ReadMedico() {
		super("./Medicos.csv");
	}
	
	@Override
	public void CargarUsuario(String[] items, Clinica clinica) {	
		Medico nuevo = new Medico(items[0],items[1],items[2], items[3], items[4]);
		String especialidades = items[5];
        String [] especialidad = especialidades.split(" ");
        for (String i: especialidad) {
        	nuevo.addEspecialidad(i);
        }
        if (items.length >= 7) {
	        String obraSociales = items[6];
	        String [] obraSocial = obraSociales.split(" ");
	        for (String i: obraSocial) {
	        	nuevo.addObraSocial(i);
	        }
        }
        
        nuevo.setDiasDeLaburo(items[7]);
        
        String [] arrayFecha1 = items[8].split("-");
        LocalDateTime inicio = LocalDateTime.of(0,1,1,Integer.parseInt(arrayFecha1[2].substring(3, 5)),Integer.parseInt(arrayFecha1[2].substring(6, 8)));
        
        String [] arrayFecha2 = items[9].split("-");
        LocalDateTime cierre = LocalDateTime.of(0,1,1,Integer.parseInt(arrayFecha2[2].substring(3, 5)),Integer.parseInt(arrayFecha2[2].substring(6, 8)));
        
        String [] arrayFecha3= items[10].split("-");
        LocalDateTime duracion = LocalDateTime.of(0,1,1,Integer.parseInt(arrayFecha3[2].substring(3, 5)),Integer.parseInt(arrayFecha3[2].substring(6, 8)));
        
        nuevo.setHoraDeInicio(inicio);
        nuevo.setHoraDeCierre(cierre);
        nuevo.setDuracionDeTurno(duracion);
        
		clinica.addMedico(nuevo);
	}
}
