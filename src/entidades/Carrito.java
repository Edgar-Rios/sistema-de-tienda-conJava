package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	
	/**
	 * @param id
	 * @param fecha
	 * @param hora
	 * @param cerrado
	 * @param descuento
	 * @param cliente
	 * @param lstItemCarrito
	 * @param entrega
	 */
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
		this.entrega = entrega;
	}

	
	/**
	 * @return the entrega
	 */
	public Entrega getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}


	/**
	 * @param hora the hora to set
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	/**
	 * @return the cerrado
	 */
	public boolean isCerrado() {
		return cerrado;
	}


	/**
	 * @param cerrado the cerrado to set
	 */
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}


	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}


	/**
	 * @param descuento the descuento to set
	 */
	protected void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the lstItemCarrito
	 */
	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}


	/**
	 * @param lstItemCarrito the lstItemCarrito to set
	 */
	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}
	
	
	
//	METODOS
	

	public boolean agregarItem(Articulo articulo, int cantidad) {
		
		ItemCarrito item = traerItem(articulo);
		
		if(item != null) {
			int cantidadActual = item.getCantidad();
			item.setCantidad(cantidadActual + cantidad);
		}else {
			ItemCarrito nuevoItem = new ItemCarrito(articulo, cantidad);
			this.lstItemCarrito.add(nuevoItem);
		}
		
		return true;
	}
	
	public boolean eliminarItem(Articulo articulo, int cantidad) {
		
		ItemCarrito item = traerItem(articulo);
		
		if(item == null)
			return false;
		
		if(item.getCantidad() > cantidad) {
			int cantidadActual = item.getCantidad();
			item.setCantidad(cantidadActual - cantidad);
		}else {
			this.lstItemCarrito.remove(item);
		}
		
		return true;
	}
	
	public double calcularTotalCarrito() {
		double total = 0;
		
		for(ItemCarrito item : this.lstItemCarrito) {
			total += item.calcularSubTotalItem();
		}
		
		return total;
	}
	
	public double calcularDescuentoDia(int diaDescuento, int porcentajeDescuentoDia) {
		
		if(this.getFecha().getDayOfWeek().getValue() == diaDescuento)
			return calcularTotalCarrito() * (porcentajeDescuentoDia/100);
	
		return 0;
	}
	
	public double calcularDescuentoEfectivo(double porcentajeDescuento) {
		return calcularTotalCarrito() * (porcentajeDescuento/100);
	}
	
	
	public double calcularDescuentoCarrito(int diaDescuento, double pocentajeDescuentoDia, double porcentajeDescuentoEfectivo) {
		
		double descuentoDia = calcularDescuentoDia(diaDescuento, diaDescuento);
		double descuentoEfectivo = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		
		double descuento = descuentoDia >= descuentoEfectivo? descuentoDia : descuentoEfectivo;
		
		setDescuento(descuento);
		return descuento;
	}
	
	
	public double totalAPagarCarrito() {
		return calcularTotalCarrito()- this.descuento;
	}
//	auxiliares

	private ItemCarrito traerItem(Articulo articulo) {
		ItemCarrito itemCarrito = null;
		
		for(ItemCarrito item : this.lstItemCarrito) {
			if(item.getArticulo().equals(articulo))
				itemCarrito = item;
		}
		
		return itemCarrito;
	}
}
