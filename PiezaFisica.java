import java.util.ArrayList;
import java.util.List;

/**
 * Class PiezaFisica
 */
public class PiezaFisica {

  //
  // Fields
  //

  private String nombre;
  private String tipo;
  private String dimensiones;
  private String ubicacion;
  private List<ElementoMobiliario> mobiliario;
  
  //
  // Constructors
  //
  public PiezaFisica(String nombre, String tipo, String dimensiones, String ubicacion) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.dimensiones = dimensiones;
    this.ubicacion = ubicacion;
    this.mobiliario = new ArrayList<>();
  }

  //
  // Accessor methods
  //

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
   * Set the value of tipo
   * @param newVar the new value of tipo
   */
  public void setTipo(String newVar) {
    tipo = newVar;
  }

  /**
   * Get the value of tipo
   * @return the value of tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Set the value of dimensiones
   * @param newVar the new value of dimensiones
   */
  public void setDimensiones(String newVar) {
    dimensiones = newVar;
  }

  /**
   * Get the value of dimensiones
   * @return the value of dimensiones
   */
  public String getDimensiones() {
    return dimensiones;
  }

  /**
   * Set the value of ubicacion
   * @param newVar the new value of ubicacion
   */
  public void setUbicacion(String newVar) {
    ubicacion = newVar;
  }

  /**
   * Get the value of ubicacion
   * @return the value of ubicacion
   */
  public String getUbicacion() {
    return ubicacion;
  }

  /**
   * Get the list of mobiliario
   * @return the list of mobiliario
   */
  public List<ElementoMobiliario> getMobiliario() {
    return new ArrayList<>(mobiliario);
  }

  //
  // Other methods
  //

  /**
   * Consulta las dimensiones de la pieza
   */
  public void consultarDimensiones() {
    System.out.println("Dimensiones de " + nombre + ": " + dimensiones);
  }

  /**
   * Muestra información de la pieza
   */
  public void mostrarInformacion() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Tipo: " + tipo);
    System.out.println("Ubicación: " + ubicacion);
    System.out.println("Dimensiones: " + dimensiones);
  }

  /**
   * Agrega mobiliario a la pieza
   * @param elemento el elemento a agregar
   */
  public void agregarMobiliario(ElementoMobiliario elemento) {
    mobiliario.add(elemento);
  }

  /**
   * Consulta el mobiliario de la pieza
   */
  public void consultarMobiliario() {
    System.out.println("Mobiliario en " + nombre + ":");
    for (ElementoMobiliario elemento : mobiliario) {
      System.out.println("- " + elemento.getTipo() + " (Cantidad: " + elemento.getCantidad() + ")");
    }
  }
}