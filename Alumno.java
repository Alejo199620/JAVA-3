import java.util.ArrayList;
import java.util.List;

/**
 * Class Alumno
 */
public class Alumno extends Persona {

  //
  // Fields
  //

  private String grado;
  private List<Curso> cursosInscritos;
  
  //
  // Constructors
  //
  public Alumno(String id, String nombre, String contacto, String grado) {
    super(id, nombre, contacto, "Alumno");
    this.grado = grado;
    this.cursosInscritos = new ArrayList<>();
  }

  //
  // Accessor methods
  //

  /**
   * Set the value of grado
   * @param newVar the new value of grado
   */
  public void setGrado(String newVar) {
    grado = newVar;
  }

  /**
   * Get the value of grado
   * @return the value of grado
   */
  public String getGrado() {
    return grado;
  }

  /**
   * Get the list of cursos inscritos
   * @return the list of cursos
   */
  public List<Curso> getCursosInscritos() {
    return new ArrayList<>(cursosInscritos);
  }

  //
  // Other methods
  //

  /**
   * Inscribe al alumno en un curso
   * @param curso el curso a inscribir
   */
  public void inscribirCurso(Curso curso) {
    cursosInscritos.add(curso);
    curso.agregarAlumno(this);
  }

  /**
   * Consulta los cursos del alumno
   */
  @Override
  public void consultarCursos() {
    System.out.println("Cursos inscritos para " + getNombre() + ":");
    for (Curso curso : cursosInscritos) {
      System.out.println("- " + curso.getNombre());
    }
  }

  /**
   * Muestra los profesores del alumno
   */
  public void verProfesores() {
    System.out.println("Profesores de " + getNombre() + ":");
    for (Curso curso : cursosInscritos) {
      Profesor profesor = curso.getProfesor();
      if (profesor != null) {
        System.out.println("- " + profesor.getNombre() + " (" + curso.getNombre() + ")");
      }
    }
  }
}