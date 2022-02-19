package entidades;

import java.time.LocalTime;

public class DiaRetiro {
	
	private int id;
	private int diaSemana;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int intervalo;
	
	
	/**
	 * @param id
	 * @param diaSemana
	 * @param horaDesde
	 * @param horaHasta
	 * @param intervalo
	 * @throws Exception 
	 */
	public DiaRetiro(int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) throws Exception {
		super();

		if(horaDesde.isAfter(horaHasta))
			throw new Exception("Error ilogico en el seteo de las horas");
		
		this.id = id;
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.intervalo = intervalo;
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
	 * @return the diaSemana
	 */
	public int getDiaSemana() {
		return diaSemana;
	}


	/**
	 * @param diaSemana the diaSemana to set
	 */
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}


	/**
	 * @return the horaDesde
	 */
	public LocalTime getHoraDesde() {
		return horaDesde;
	}


	/**
	 * @param horaDesde the horaDesde to set
	 */
	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}


	/**
	 * @return the horaHasta
	 */
	public LocalTime getHoraHasta() {
		return horaHasta;
	}


	/**
	 * @param horaHasta the horaHasta to set
	 */
	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}


	/**
	 * @return the intervalo
	 */
	public int getIntervalo() {
		return intervalo;
	}


	/**
	 * @param intervalo the intervalo to set
	 */
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
	
	
}
