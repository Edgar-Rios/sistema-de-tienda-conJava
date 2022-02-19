package entidades;

import java.time.LocalDate;

public abstract class Entrega {
	protected int id;
	protected LocalDate fecha;
	protected boolean efectivo;
	/**
	 * @param id
	 * @param fecha
	 * @param efectivo
	 */
	protected Entrega(int id, LocalDate fecha, boolean efectivo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
	}
	
	
	@Override
	public String toString() {
		return "Entrega [id=" + id + ", fecha=" + fecha + ", efectivo=" + efectivo + "]";
	}


	/**
	 * @return the id
	 */
	protected int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the fecha
	 */
	protected LocalDate getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	protected void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the efectivo
	 */
	protected boolean isEfectivo() {
		return efectivo;
	}


	/**
	 * @param efectivo the efectivo to set
	 */
	protected void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	
	
	
}
