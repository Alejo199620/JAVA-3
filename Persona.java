/**
 * Class Persona
 */
public class Persona {

  //
  // Fields
  //

  private String id;
  private String nombre;
  private String contacto;
  private String rol;
  
  //
  // Constructors
  //
  public Persona(String id, String nombre, String contacto, String rol) {
    this.id = id;
    this.nombre = nombre;
    this.contacto = contacto;
    this.rol = rol;
  }
  
  //
  // Methods
  //

  //
  // Accessor methods
  //

  /**
   * Set the value of id
   * @param newVar the new value of id
   */
  public void setId(String newVar) {
    id = newVar;
  }

  /**
   * Get the value of id
   * @return the value of id
   */
  public String getId() {
    return id;
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
   * Set the value of contacto
   * @param newVar the new value of contacto
   */
  public void setContacto(String newVar) {
    contacto = newVar;
  }

  /**
   * Get the value of contacto
   * @return the value of contacto
   */
  public String getContacto() {
    return contacto;
  }

  /**
   * Set the value of rol
   * @param newVar the new value of rol
   */
  public void setRol(String newVar) {
    rol = newVar;
  }

  /**
   * Get the value of rol
   * @return the value of rol
   */
  public String getRol() {
    return rol;
  }

  //
  // Other methods
  //

  /**
   */
  public void consultarCursos() {
    // Implementación según el tipo de persona
  }

  /**
   */
  public void consultarDatos() {
    System.out.println("ID: " + id);
    System.out.println("Nombre: " + nombre);
    System.out.println("Contacto: " + contacto);
    System.out.println("Rol: " + rol);
  }
}