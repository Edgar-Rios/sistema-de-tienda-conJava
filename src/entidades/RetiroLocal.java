package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega{
	
	private LocalTime horaEntrega;

	/**
	 * @param id
	 * @param fecha
	 * @param efectivo
	 * @param horaEntrega
	 */
	protected RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		super(id, fecha, efectivo);
		this.horaEntrega = horaEntrega;
	}

	/**
	 * @return the horaEntrega
	 */
	protected LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	/**
	 * @param horaEntrega the horaEntrega to set
	 */
	protected void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	
	
	
}
