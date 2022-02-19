package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	private LocalDate fecha;
	private LocalTime hora;
	private boolean ocupado;
	
	/**
	 * @param fecha
	 * @param hora
	 * @param ocupado
	 */
	public Turno(LocalDate fecha, LocalTime hora, boolean ocupado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.ocupado = ocupado;
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
	 * @return the ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}
	
	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}	
	
}
