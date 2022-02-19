package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import myLib.CUIT;
import myLib.HorasIguales;


public class Comercio extends Actor{
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diasDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Carrito> lstCarrito;
	private List<Articulo> lstArticulo;
	
	/**
	 * @param nombreComercio
	 * @param cuit
	 * @param costoFijo
	 * @param costoPorKm
	 * @param diasDescuento
	 * @param porcentajeDescuentoDia
	 * @param porcentajeDescuentoEfectivo
	 * @param lstDiaRetiro
	 * @param lstCarrito
	 * @param lstArticulo
	 * @throws Exception 
	 */
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diasDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diasDescuento = diasDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstCarrito = new ArrayList<Carrito>();
		this.lstArticulo = new ArrayList<Articulo>();
	}


	private void setCuit(long cuit) throws Exception {
		if(!CUIT.test(cuit))
			throw new Exception("Error: CUIT invalido");
		
		this.cuit = cuit;		
	}


	@Override
	protected boolean validarIdentificadorUnico() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	METODOS
	public List<Turno> generarTurnosLibres(LocalDate fecha) throws Exception{
		
		if(!esDiaRetiro(fecha))
			throw new Exception("Error la fecha no es un dia de retiro");
		
		List<Turno> lista = new ArrayList<Turno>();
		List<Carrito> carritos = traerCarritosRetiroLocal(fecha);
		DiaRetiro diaRetiro = traerDiaRetiro(fecha);
		
		LocalTime horaAtencion = diaRetiro.getHoraDesde();
		
		while(horaAtencion.isBefore(diaRetiro.getHoraHasta())) {
			
			boolean ocupado = esHorarioOcupado(horaAtencion, carritos);
			if(!ocupado) lista.add(new Turno(fecha, horaAtencion, false));
			
			horaAtencion = horaAtencion.plusMinutes(diaRetiro.getIntervalo());
			ocupado = false;
		}
			
		return lista;
	}
	
	public List<Turno> generarTurnosOcupados(LocalDate fecha) throws Exception{
		
		if(!esDiaRetiro(fecha))
			throw new Exception("Error la fecha no es un dia de retiro");
		
		List<Turno> lista = new ArrayList<Turno>();
		List<Carrito> carritos = traerCarritosRetiroLocal(fecha);
		DiaRetiro diaRetiro = traerDiaRetiro(fecha);
		
		LocalTime horaAtencion = diaRetiro.getHoraDesde();
		
		while(horaAtencion.isBefore(diaRetiro.getHoraHasta())) {
			
			boolean ocupado = esHorarioOcupado(horaAtencion, carritos);
			if(ocupado) lista.add(new Turno(fecha, horaAtencion, ocupado));
			
			horaAtencion = horaAtencion.plusMinutes(diaRetiro.getIntervalo());
			ocupado = false;
		}
			
		return lista;
	}
	
	public List<Turno> generarAgenda(LocalDate fecha) throws Exception{
		
		if(!esDiaRetiro(fecha))
			throw new Exception("Error la fecha no es un dia de retiro");
		
		List<Turno> lista = new ArrayList<Turno>();
		List<Carrito> carritos = traerCarritosRetiroLocal(fecha);
		DiaRetiro diaRetiro = traerDiaRetiro(fecha);
		
		LocalTime horaAtencion = diaRetiro.getHoraDesde();
		
		while(horaAtencion.isBefore(diaRetiro.getHoraHasta())) {

			boolean ocupado = esHorarioOcupado(horaAtencion, carritos);			
			if(!ocupado) lista.add(new Turno(fecha, horaAtencion, false));
			if(ocupado) lista.add(new Turno(fecha, horaAtencion, true));
			
			horaAtencion = horaAtencion.plusMinutes(diaRetiro.getIntervalo());
			ocupado = false;
		}
			
		return lista;
	}
	
	
//	6
	public boolean agregarDiaRetiro(int diaSemana, LocalTime desde, LocalTime hasta, int intervalo) throws Exception {
		
		if(traerDiaRetiro(diaSemana) != null) 
			throw new Exception("Error: ya existe un dia el dia de retiro");
		
		DiaRetiro diaRetiro = new DiaRetiro(diaSemana, diaSemana, desde, hasta, intervalo);
		this.lstDiaRetiro.add(diaRetiro);
		
		return true;
	}
	
	
	
//	auxiliares
	
	private boolean esDiaRetiro(LocalDate fecha) {
		
		for(DiaRetiro dia : this.lstDiaRetiro) {
			if(dia.getDiaSemana() == fecha.getDayOfWeek().getValue())
				return true;
		}
		
		return false;
	}
	
	
	private List<Carrito> traerCarritosRetiroLocal(LocalDate fecha){
		List<Carrito> lista = new ArrayList<Carrito>();
		
		for(Carrito c : this.lstCarrito) {
			Entrega entrega = c.getEntrega();
			if(entrega.getFecha().isEqual(fecha))
				if(entrega instanceof RetiroLocal) 
					lista.add(c);
		}
		
		return lista;
	}
	
	
	
	private DiaRetiro traerDiaRetiro(LocalDate fecha) {
		DiaRetiro diaRetiro = null;
		
		for(DiaRetiro d : this.lstDiaRetiro) {
			if(d.getDiaSemana() == fecha.getDayOfWeek().getValue())
				diaRetiro = d;
		}
		
		return diaRetiro;
	}
	
	private DiaRetiro traerDiaRetiro(int diaSemana) {
		DiaRetiro diaRetiro = null;
		
		for(DiaRetiro d : this.lstDiaRetiro) {
			if(d.getDiaSemana() == diaSemana) {
				diaRetiro = d;
				break;
			}
		}
		
		return diaRetiro;
	}
	
	private boolean esHorarioOcupado(LocalTime horaAtencion, List<Carrito> lista) {
		
		for(Carrito c : lista) {
			if(HorasIguales.test(horaAtencion, ((RetiroLocal) c.getEntrega()).getHoraEntrega())) {
				return true;
			}
		}
		
		return false;
	}
	
}
