import java.util.ArrayList;
import java.util.List;

/**
 * Class Profesor
 */
public class Profesor extends Persona {

  //
  // Fields
  //

  private String especialidad;
  private List<Curso> cursosAsignados;
  
  //
  // Constructors
  //
  public Profesor(String id, String nombre, String contacto, String especialidad) {
    super(id, nombre, contacto, "Profesor");
    this.especialidad = especialidad;
    this.cursosAsignados = new ArrayList<>();
  }

  //
  // Accessor methods
  //

  /**
   * Set the value of especialidad
   * @param newVar the new value of especialidad
   */
  public void setEspecialidad(String newVar) {
    especialidad = newVar;
  }

  /**
   * Get the value of especialidad
   * @return the value of especialidad
   */
  public String getEspecialidad() {
    return especialidad;
  }

  /**
   * Get the list of cursos asignados
   * @return the list of cursos
   */
  public List<Curso> getCursosAsignados() {
    return new ArrayList<>(cursosAsignados);
  }

  //
  // Other methods
  //

  /**
   * Asigna un curso al profesor
   * @param curso el curso a asignar
   */
  public void asignarCurso(Curso curso) {
    cursosAsignados.add(curso);
    curso.setProfesor(this);
  }

  /**
   * Consulta los cursos del profesor
   */
  @Override
  public void consultarCursos() {
    System.out.println("Cursos asignados a " + getNombre() + ":");
    for (Curso curso : cursosAsignados) {
      System.out.println("- " + curso.getNombre());
    }
  }

  /**
   * Muestra los alumnos de un curso específico
   * @param curso el curso a consultar
   */
  public void verAlumnos(Curso curso) {
    if (cursosAsignados.contains(curso)) {
      System.out.println("Alumnos en " + curso.getNombre() + ":");
      for (Alumno alumno : curso.getAlumnos()) {
        System.out.println("- " + alumno.getNombre());
      }
    } else {
      System.out.println("Este profesor no está asignado a este curso");
    }
  }
}