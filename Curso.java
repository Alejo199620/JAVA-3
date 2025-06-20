import java.util.ArrayList;
import java.util.List;

/**
 * Class Curso
 */
public class Curso {

  //
  // Fields
  //

  private String codigo;
  private String nombre;
  private String horario;
  private Profesor profesor;
  private PiezaFisica aula;
  private List<Alumno> alumnos;
  
  //
  // Constructors
  //
  public Curso(String codigo, String nombre, String horario) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.horario = horario;
    this.alumnos = new ArrayList<>();
  }

  //
  // Accessor methods
  //

  /**
   * Set the value of codigo
   * @param newVar the new value of codigo
   */
  public void setCodigo(String newVar) {
    codigo = newVar;
  }

  /**
   * Get the value of codigo
   * @return the value of codigo
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Set the value of nombre
   * @param newVar the new value of nombre
   */
  public void setNombre(String newVar) {
    nombre = newVar;
  }

  /**
   * Get the value of nombre
   * @return the value of nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Set the value of horario
   * @param newVar the new value of horario
   */
  public void setHorario(String newVar) {
    horario = newVar;
  }

  /**
   * Get the value of horario
   * @return the value of horario
   */
  public String getHorario() {
    return horario;
  }

  /**
   * Set the value of profesor
   * @param profesor the new profesor
   */
  public void setProfesor(Profesor profesor) {
    this.profesor = profesor;
  }

  /**
   * Get the value of profesor
   * @return the profesor
   */
  public Profesor getProfesor() {
    return profesor;
  }

  /**
   * Set the value of aula
   * @param aula the new aula
   */
  public void setAula(PiezaFisica aula) {
    this.aula = aula;
  }

  /**
   * Get the value of aula
   * @return the aula
   */
  public PiezaFisica getAula() {
    return aula;
  }

  /**
   * Get the list of alumnos
   * @return the list of alumnos
   */
  public List<Alumno> getAlumnos() {
    return new ArrayList<>(alumnos);
  }

  //
  // Other methods
  //

  /**
   * Agrega un alumno al curso
   * @param alumno el alumno a agregar
   */
  public void agregarAlumno(Alumno alumno) {
    if (!alumnos.contains(alumno)) {
      alumnos.add(alumno);
    }
  }

  /**
   * Consulta los estudiantes del curso
   */
  public void consultarEstudiantes() {
    System.out.println("Alumnos en " + nombre + ":");
    for (Alumno alumno : alumnos) {
      System.out.println("- " + alumno.getNombre());
    }
  }
}