package entidades;

public class ItemCarrito {
	
	private Articulo articulo;
	private int cantidad;
	
	/**
	 * @param articulo
	 * @param cantidad
	 */
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	/**
	 * @return the articulo
	 */
	public Articulo getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
//	METODOS
	
	public double calcularSubTotalItem() {
		return  this.articulo.getPrecio() * this.getCantidad();
	}
	
	
}
