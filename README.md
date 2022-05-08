# **TurnoFacil**

<!-- Responsable TURNOFACIL? [2.1] -->
<!-- Representacion secretaria [2.2] -->
<!-- -->

Este proyecto provee una solución a una problemática planteada por TurnoFacil, la cuál permitirá sacar turnos para médicos mediante una aplicación web. Esta misma se comercializara a distintas instituciones médicas como clínicas y consultorios por lo que deberá ser fácilmente instanciable para cada una de ellas.

JIRA: https://felipe123.atlassian.net/jira/software/projects/TPMT/boards/3/backlog
![TurnoFacil](https://p0.piqsels.com/preview/460/190/356/medical-senior-health-doctor.jpg)

## Indice

  A continuación se listara los puntos 
- [Backlog](#backlog)
- [User Story Mapping](#user-story-mapping)
- [Vision](#vision)
- [Definition of DONE](#definition-of-done)
- [Use-Case Specification](#use-case-specification)

## Backlog
<a href="https://felipe123.atlassian.net/jira/software/projects/TPMT/boards/3/backlog">
  <img width="720" src="https://www.soldevelo.com/blog/wp-content/uploads/Scrum-board-scaled.jpeg"
       alt="Bklog">
</a>

_Para acceder al backlog haga click en la imagen que se encuentra a continuación._

## User Story Mapping
<a href="https://miro.com/welcomeonboard/bWNHbHFPWmRTUTF1clBsWEFiNEV2T3VPelpRbVNjcmY3ZXI0WlpSNndLaTRtVFN0ODFrZXlzUkVxc0FyUDA2ZXwzMDc0NDU3MzY2NTM4MTc3MjY4?share_link_id=481042348205">
  <img width="720" src="https://serving.photos.photobox.com/78001070b160c65cdb737690cce66484945398de95fb18ddd114a7ada2e17045da72a7a3.jpg"
       alt="USM">
</a>

_Para acceder al User Story Mapping haga click en la imagen que se encuentra a continuación._

## Vision
### 1. Vision Statement

#### Problem Statement

El problema del proceso de sacar turnos de manera presencial afecta tanto a pacientes como a las instituciones cuyo impacto en los pacientes es la movilidad y la demora al momento de pedir el turno, a su vez, las instituciones tienen una sobrecarga de pacientes a la hora de pedir estos turnos y cargar los datos de los mismos. Una solución exitosa permitiría mejorar la eficiencia y organización, agilizando el registro de un turno y permitiría mayor cantidad de atendidos.

#### Product Statement

Para **medicos, secretarios, pacientes y administradores** quienes atienden, organizan, asisten o administran el sitio web.
El sistema de administración de turnos es una herramienta que permite el registro on-line de turnos mediante un calendario, acceso a la información de los horarios a atender y disponibilidad. \
&#8195; A diferencia del sistema de obtención de turno existente, nuestro producto proporciona mas información tanto a las instituciones sobre los pacientes, como a los usuarios la disponibilidad de turnos; una mayor comodidad para los mismos y mejor organización en cuanto a la hora de obtenerlos y proveerlos.

### 2. Target group

#### Stakeholders Summary
- El **responsable IT** representa a la dirección de IT de la empresa TurnoFacil , este tiene la responsabilidad de promover los requerimientos del proyecto y seguimiento del mismo.
- El **responsable de la institución médica** representa a una institución que está interesada en el proyecto y quiere utilizarlo.
- El **médico** es quien utiliza la aplicación para atender turnos.
- La **secretaria** representa a la secretaria que es responsable de la asignación de turnos y administración de los horarios de los médicos.
- El **paciente** representa a los pacientes y su responsabilidad es asegurar que el sistema satisfaga las necesidades de los pacientes.
 
####  User summary
- El **responsable IT** representa a la dirección de IT de la empresa TurnoFacil , este tiene la responsabilidad de promover los requerimientos del proyecto y seguimiento del mismo. 
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

Este proyecto generara un nuevo sistema de reservación de turnos de manera virtual que permitirá la obtención de los mismos mediante dispositivos con conexión on-line.

El sistema de turnos actual carece de eficiencia a la hora de obtener turnos rápidamente. El sistema actual es de manera presencial o consultando mediante llamadas telefónicas, las cuales son obsoletas porque propagan errores y confusiones . El nuevo sistema permitirá obtenerlos a través de Internet.

El nuevo sistema llevara a las instituciones correspondientes a mejor organización en los sistemas de registro de pacientes, medicos y secretarias haciendo mas eficientes las funciones administrativas. brindando a los pacientes una mejor comodidad a la hora de tener que reservar un turno evitando llamadas ocupadas o filas innecesarias para la obtención del mismo.

## Definition of DONE

El nuevo sistema llevara a las instituciones correspondientes a mejor organizacion en los sistemas de registro de pacientes, medicos y secretarias haciendo mas eficientes las funciones administrativas. brindando a los pacientes una mejor comodidad a la hora de tener que reservar un turno evitando llamadas ocupadas o filas innecesarias para la obtencion del mismo, y ganando por lo tanto pacientes que buscan facilidad y sencillez en el sistema.


El equipo tiene en cuenta los siguientes puntos para evaluar cuándo se ha completado el trabajo sobre el incremento de producto.

- Se cumple todos los criterios de aceptación de cada User Story.
- Revisión del código por parte de los compañeros y aprobación de los mismos.
- Cobertura de prueba de mas del 80 %.
- La mayor parte de la documentación completa.
- Sin defectos conocidos.
- Pruebas de funcionales realizadas.

## Use-Case Specification

### **<Use-Case Reservar Turno\>**

### 1. Brief Description

&#8195; El paciente debe poder seleccionar un turno que haya disponible.

### 2. Primary-Secondary Actors

&#8195; El Paciente es el único actor y es el primario.

### 3. Trigger

&#8195; El caso de uso comienza cuando el Paciente quiere sacar un turno con determinado médico.

### 4. Basic Flow of Events
 
1. El Reservar Turno comienza cuando el Paciente quiere sacar un turno con determinado médico. 
2. El sistema le debe preguntar al paciente que médico, especialidad, rango de fechas y turno (mañana o tarde) quiere asistir. 
3. El paciente ingresa los datos. 
4. El sistema verifica que el médico tenga turnos disponibles. 
5. El sistema le proporciona un cronograma con los requisitos que indico el paciente. 
6. El paciente debe seleccionar una fecha y horario que se dispone en el instituto. 
7. El sistema le muestra la reserva. 
8. El sistema pide confirmación de datos personales (nombre, apellido, dirección, teléfono, email, obra social y número de afiliado). 
9. El paciente afirma que los datos son correctos. 
10. El sistema verifica que el médico pertenezca a una obra social o que cobra un diferencial para su obra social. 
11. El sistema verifica que si pertenece a una obra social o que no cobra un diferencial para su obra social. 
12. El sistema guarda el turno. 
13. El Caso de Uso finaliza.

### 5. Alternative Flows

**<Use-Case-Alternative 1\>** El sistema verifica que el médico no tiene turnos disponibles.

&#8194; 4. El sistema verifica que el médico tenga turnos disponibles. \
&#8195; 4.1. El sistema verifica que el médico no tiene turno disponible. \
&#8195; 4.2. El sistema informa de la situación. \
&#8195; 4.3. El sistema pregunta si quiere ver los turnos de la siguiente semana. \
&#8195; 4.4. El usuario ingresa su respuesta afirmativa. \
&#8195; 4.5. Ir al paso 4.

**<Use-Case-Alternative 2\>** El usuario ingresa que no quiere ver los turnos de la siguiente semana.

&#8194; 4.3. El sistema pregunta si quiere ver los turnos de la siguiente semana. \
&#8195; 4.3.1. El usuario ingresa su respuesta negativa. \
&#8195; 4.3.2. El sistema pregunta si quiere modificar el filtrado o quiere salir de la selección de turnos. \
&#8195;	4.3.3. El usuario quiere modificar el filtrado. \
&#8195; 4.3.4. Ir al paso 2. 

**<Use-Case-Alternative 3\>**  El usuario ingresa que no quiere ver los turnos de la siguiente semana.

&#8194; 9. El sistema pide confirmación de datos personales (nombre, apellido, dirección, teléfono, email, obra social y número de afiliado). \
&#8195; 9.1. El paciente afirma que los datos no son correctos. \
&#8195; 9.2. PE. \
&#8195; 9.3. Ir al paso 10. 

**<Use-Case-Alternative 4\>**  El sistema verifica que no pertenece a una obra social o que si cobra un diferencial para su obra social.

&#8194; 10. El sistema verifica que el médico pertenezca a una obra social o que cobra un diferencial para su obra social. \
&#8195; 10.2. El sistema informa de la situación. \
&#8195; 10.3. El sistema pregunta si quiere sacar el turno igual o no. \
&#8195; 10.4. El paciente responde que si quiere sacar el turno igual. \
&#8195; 10.5. Ir a paso 12.

**<Use-Case-Alternative 5\>**  El paciente responde que no quiere sacar el turno.

&#8194; 10.3. El sistema pregunta si quiere sacar el turno igual o no. \
&#8195;	10.3.1. El paciente no quiere sacar el turno. \
&#8195;	10.3.2. El sistema pregunta si quiere sacar un turno con otro médico. \
&#8195;	10.3.3. El paciente responde afirmativamente. \
&#8195;	10.3.4. ir al paso 2.

**<Use-Case-Alternative 6\>**  El paciente responde negativamente.

&#8194; 10.3.2. El sistema pregunta si quiere sacar un turno con otro médico. \
&#8195;	10.3.2.1. El paciente responde negativamente. \
&#8195;	10.3.2.2. El Caso de Uso finaliza.

### 6. Extension Points
&#8195; El CU que extiende es Pedir datos personales.
### 7. Finalization of the use case

- El CU termina porque se registra el turno (13).
- El paciente no quiere modificar el filtrado (4.3.2.2).
- El paciente no quiere sacar un turno con un médico que no esté en una obra social o que tenga un diferencial con la obra social (10.3.2.2).
- Cancela la acción. 
