# TurnoFacil
<!-- Responsable TURNOFACIL? [2.1] -->
<!-- Representacion secretaria [2.2] -->
<!-- -->
Este proyecto provee una solucion a una problematica planteada por Turno Facil, la cuál permitira sacar turnos para médicos mediante una aplicación web. Esta misma se comercializara a distintas instituciones médicas como clínicas y consultorios por lo que deberá ser fácilmente instanciable para cada una de ellas.


![TurnoFacil](https://p0.piqsels.com/preview/460/190/356/medical-senior-health-doctor.jpg)


## Indice 

  - [Backlog](#backlog)
  - [User Story Mapping](#user-story-mapping)
  - [Vision](#vision)
  - [Criterio de DONE](#criterio-de-done)
  - [Especificación de casos de usos](#especificación-de-casos-de-usos)

## Backlog


<a href="https://felipe123.atlassian.net/jira/software/projects/TPMT/boards/3/backlog">
  <img width="720" src="https://www.soldevelo.com/blog/wp-content/uploads/Scrum-board-scaled.jpeg"
       alt="Bklog">
</a> 

_Para acceder al backlog haga click en la imagen que se encuentra a continuacion._


##  User Story Mapping


<a href="https://miro.com/welcomeonboard/bWNHbHFPWmRTUTF1clBsWEFiNEV2T3VPelpRbVNjcmY3ZXI0WlpSNndLaTRtVFN0ODFrZXlzUkVxc0FyUDA2ZXwzMDc0NDU3MzY2NTM4MTc3MjY4?share_link_id=481042348205">
  <img width="720" src="https://serving.photos.photobox.com/78001070b160c65cdb737690cce66484945398de95fb18ddd114a7ada2e17045da72a7a3.jpg"
       alt="USM">
</a>

_Para acceder al User Story Mapping haga click en la imagen que se encuentra a continuacion._


## Vision

### 1. Vision Statement

####  Problem Statement

El problema del proceso de sacar turnos de manera presencial afecta tanto a pacientes como a las instituciones cuyo impacto en los pacientes es la movilidad y la demora al momento de pedir el turno, a su vez, las instituciones tienen una sobrecarga de pacientes a la hora de pedir estos turnos y cargar los datos de los mismos. Una solucion exitosa permitiria mejorar la eficiencia y organizacion, agilizando el registro de un turno y permitiria mayor cantidad de atendidos.
#### Product Statement
Para **medicos, secretarios, pacientes y administradores** quienes atienden, organizan, asisten o administran el sitio web.
El sistema de administracion de turnos es una herramienta que permite el registro on-line de turnos mediante un calendario, acceso a la informacion de los horarios a atender y disponibilidad. \
A diferencia del sistema de obtencion de turno existente, nuestro producto proporciona mas informacion tanto a las instituciones sobre los pacientes, como a los usuarios la disponibilidad de turnos; una mayor comodidad para los mismos y mejor organizacion en cuanto a la hora de obtenerlos y proveerlos.

### 2. Target group
 
#### Stakeholders Summary
 
- El **responsable IT** representa a la dirección de IT de la empresa TurnoFacil , este tiene la responsabilidad de promover los requerimientos del proyecto y seguimiento del mismo.
- El **responsable de la institución médica** representa a una institución que está interesada en el proyecto y quiere utilizarlo.
- El **médico** es quien utiliza la aplicación para atender turnos.
- La **secretaria** representa a la secretaria que es responsable de la asignación de turnos y administración de los horarios de los médicos.
- El **paciente** representa a los pacientes y su responsabilidad es asegurar que el sistema satisfaga las necesidades de los pacientes.
 
####  User summary
 
- El **responsable de la institución médica** gestiona y representa a los usuarios de médicos y secretarias, además de asignar a cada secretaría el grupo de médicos con los que trabaja y que secretaría le corresponde a cada médico.
- El **médico** es el encargado del listado de sus turnos venideros, el cual se autorepresenta.
- La **secretaria** será la encargada de ver pacientes los turnos y representar a los médicos.
- El **paciente** deberá realizar tanto la carga de sus datos como la adquisición de sus turnos y podrá consultar los turnos. Se autorepresenta.

### 3. Needs
 
- **Sacar turnos.** *Prioridad alta*, la obtención de turnos de manera presencial es lenta e ineficiente. La solución actual implica que los pacientes deben ir de manera presencial. \
&#8195;Esta nueva solución implica que los pacientes tienen una forma de obtener turnos de manera on-line para ahorrar tiempos y tener una mayor comodidad.
- **Creación de cuentas del personal.** *Prioridad alta*, el registro del personal de forma escrita es improductivo. En la solución actual (**se asume**) se registra el personal médico a través de carpetas y de manera física. \
  &#8195;Nuestra solución es crear cuentas en nuestro sistema a todo el personal, y asignado a las secretarias los médicos con los que trabaja.
- **Administrar cuentas del personal.** (**se asume**) *Prioridad alta*, gestionar información del personal mediante documentación física no es eficiente. La solución actual es registrar la información a través de carpetas y papeles difíciles de organizar. \
  &#8195;La posible solución sería registrar todo en un sistema que organice la información automáticamente y facilite la búsqueda.
- **Sacar turno.** *Prioridad alta*, el sistema actual (**se asume**) se realiza mediante la asistencia física a la institución o por un llamado telefónico.  \
&#8195;Nuestra solución implica añadir a la solución existente (ya que estos métodos se van a poder seguir utilizando dada la capacidad de la secretaría para poder crear cuentas y asignar turnos) la capacidad de hacerlo de forma on-line realizado por el paciente permitiéndole buscar tanto por especialidad, obra social y horario.
- **Visualizar turnos**. *Prioridad media*, tener que preguntar información sobre los turnos es ineficaz. La solución actual es una consulta personal a la secretaria. \
&#8195;Nosotros damos la opción al paciente para que visualice por su cuenta la información de los turnos de manera virtual.
- **Cancelar turnos**. *Prioridad media*, En la actualidad (**se asume**) la cancelación de turno se hace mediante la comunicación(de forma presencial o por llamado). También la secretaria tiene que avisar a los pacientes manualmente si el médico tiene una urgencia. \
&#8195;Nosotros le damos la posibilidad al paciente de poder cancelarlo on-line, permitiendo que el  sistema haga disponible el turno recién recién liberado. Y también les avisa automáticamente (por el medio de preferencia) a los pacientes si sus turnos fueron modificados o reasignados por la secretaría.
- **Administrar turnos**. *Prioridad media*, dado que en la actualidad (**se asume**) el método de organización es mediante carpetas, nuestro sistema propone una organización digital, que aparte de ser más seguro y ordenado, permite cualquier tipo de modificación sin perjudicar a la prolijidad.





### 4. Product

- Login: Facil acceso para pacientes, medicos y secretarias proviendo una mayor accesibilidad
- Administracion: Provee a las instituciones opciones para una mayor eficiacia en sus responsabilidades
- Ver calendario: Da una imagen visual, tanto a los pacientes como a los medicos y las secretarias que es amigable con ellos.
- Reservar Turno: Permite reservar turno teniendo en cuenta la disponibilidad de los medicos y la preferencia de los pacientes.


### 5. Business goals

Este proyecto generara un nuevo sistema de reservacion de turnos de manera virtual que permitira la obtencion de los mismos mediante dispositivos con conexion on-line. 

El sistema de turnos actual carece de eficiencia a la hora de obtener turnos rápidamente. El sistema actual es de manera presencial o consultando mediante llamadas telefonicas, las cuales son obsoletas porque propagan errores y confusiones . El nuevo sistema permitira obtenerlos a través de Internet. 

El nuevo sistema llevara a las instituciones correspondientes a mejor organizacion en los sistemas de registro de pacientes, medicos y secretarias haciendo mas eficientes las funciones administrativas. brindando a los pacientes una mejor comodidad a la hora de tener que reservar un turno evitando llamadas ocupadas o filas innecesarias para la obtencion del mismo, y ganando por lo tanto pacientes que buscan facilidad y sencillez en el sistema.

## Criterio de DONE
 
El equipo tiene en cuenta los siguientes puntos para evaluar cuándo se ha completado el trabajo sobre el incremento de producto.
- Se cumple todos los criterios de aceptacion de cada User Story.
- Revisión del código por parte de los compañeros y aprobacion de los mismos.
- Cobertura de prueba de mas del 80 %.
- La mayor parte de la documentacion completa.
- Sin defectos conocidos.
- Pruebas de funcionales realizadas.


## Especificación de casos de usos
