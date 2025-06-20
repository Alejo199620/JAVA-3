/**
 * Class Director
 */
public class Director extends Persona {

  //
  // Constructors
  //
  public Director(String id, String nombre, String contacto) {
    super(id, nombre, contacto, "Director");
  }
  
  //
  // Other methods
  //

  /**
   * Supervisa la información general del sistema
   */
  public void supervisar(Sistema sistema) {
    System.out.println("=== Informe de Supervisión ===");
    System.out.println("Total alumnos: " + sistema.getAlumnos().size());
    System.out.println("Total profesores: " + sistema.getProfesores().size());
    System.out.println("Total cursos: " + sistema.getCursos().size());
    System.out.println("Total piezas físicas: " + sistema.getPiezasFisicas().size());
  }
}