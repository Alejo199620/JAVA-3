/**
 * Class ElementoMobiliario
 */
public class ElementoMobiliario {

  //
  // Fields
  //

  private String tipo;
  private int cantidad;
  
  //
  // Constructors
  //
  public ElementoMobiliario(String tipo, int cantidad) {
    this.tipo = tipo;
    this.cantidad = cantidad;
  }

  //
  // Accessor methods
  //

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
   * Set the value of cantidad
   * @param newVar the new value of cantidad
   */
  public void setCantidad(int newVar) {
    cantidad = newVar;
  }

  /**
   * Get the value of cantidad
   * @return the value of cantidad
   */
  public int getCantidad() {
    return cantidad;
  }
}