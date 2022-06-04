package TPE;

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
		clinica.addMedico(nuevo);
	}
}
