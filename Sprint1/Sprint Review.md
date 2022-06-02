23/5/2022

# Temas
	Los temas a tratar en esta reunión son el **diagrama de clases** y la **división de tareas**.

## Diagrama de Clases
	Decidimos crear las siguientes clases:	
 - Usuario
 - Paciente
 - Médico
 - Secretaria
 - Interfaz
 - Turno
 - Filtro
 - Clínica
 
	Se habló de que usuario es una clase abstracta con el método abstracto Visualizar_Turno.	\
	Se contempló la idea de crear la clase Personal, de la que heredarán Secretaria y Médico, para poder abstraer la funcionalidad de visualizar turno, ya que ambos deben poder filtrarlos por turno (manana, tarde) y rango de días. Pero se desechó la idea ya que no consideramos que se copiara tanto código.

## To do’s
 - Teniendo en cuenta de que las bases de datos tienen un select que bajo un criterio de búsqueda automáticamente hace un listado. ¿Hace falta hacer los filtrados en código por más que esa funcionalidad le corresponda a la base de datos?
 - Preguntar cuantos turnos crea la secretaria (una semana, un mes, un año, etc)
 - Terminar de hacer el diagrama de clases
