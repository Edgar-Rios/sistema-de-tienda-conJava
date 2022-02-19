package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega{
	
	private LocalTime horaDesde;
	private LocalTime horahasta;
	private double costo;
	private Ubicacion ubicacion;
	/**
	 * @param id
	 * @param fecha
	 * @param efectivo
	 * @param horaDesde
	 * @param horahasta
	 * @param costo
	 * @param ubicacion
	 */
	protected Envio(int id, LocalDate fecha, boolean efectivo, LocalTime horaDesde, LocalTime horahasta, double costo, Ubicacion ubicacion) {
		super(id, fecha, efectivo);
		this.horaDesde = horaDesde;
		this.horahasta = horahasta;
		this.costo = costo;
		this.ubicacion = ubicacion;
	}

	
}
