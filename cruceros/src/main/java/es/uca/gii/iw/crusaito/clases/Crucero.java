package es.uca.gii.iw.crusaito.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Crucero {
	
	public Crucero() {}
	
	@Id
	@GeneratedValue
	private Long id;
	private String cNombre;
	private String cOrigen;
	private String cDestino;
	private String cDuracion; //en dias
	private String cDescripcion;
	private String cImagen;
	private double cPrecio;
	
	@OneToOne
	private Barco barco;
	
	@OneToMany(mappedBy = "crucero")
	private List<Usuario> usuarios;
	
	@ManyToMany(mappedBy = "cruceros")
	private List<Ciudad> ciudades;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "crucero_servicio",
    	joinColumns = {@JoinColumn(name = "crucero_id", referencedColumnName = "id")},
    	inverseJoinColumns = {@JoinColumn(name = "servicio_id", referencedColumnName = "id")}
	)
	private List<Servicio> servicios;

	public Crucero(String cNombre, String cOrigen, String cDestino, String cDuracion, String cDescripcion,
			double cPrecio) {

		this.cNombre = cNombre;
		this.cOrigen = cOrigen;
		this.cDestino = cDestino;
		this.cDuracion = cDuracion;
		this.cDescripcion = cDescripcion;
		this.cPrecio = cPrecio;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getcNombre() {
		return cNombre;
	}


	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}


	public String getcOrigen() {
		return cOrigen;
	}


	public void setcOrigen(String cOrigen) {
		this.cOrigen = cOrigen;
	}


	public String getcDestino() {
		return cDestino;
	}


	public void setcDestino(String cDestino) {
		this.cDestino = cDestino;
	}


	public String getcDuracion() {
		return cDuracion;
	}


	public void setcDuracion(String cDuracion) {
		this.cDuracion = cDuracion;
	}


	public String getcDescripcion() {
		return cDescripcion;
	}


	public void setcDescripcion(String cDescripcion) {
		this.cDescripcion = cDescripcion;
	}


	public double getcPrecio() {
		return cPrecio;
	}


	public void setcPrecio(double cPrecio) {
		this.cPrecio = cPrecio;
	}


	public List<Ciudad> getCiudades() {
		return ciudades;
	}


	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getcImagen() {
		return cImagen;
	}


	public void setcImagen(String cImagen) {
		this.cImagen = cImagen;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
		servicio.getCruceros().add(this);
	}
	
	public void removeServicio(Servicio servicio) {
		this.servicios.remove(servicio);
		servicio.getCruceros().remove(servicio);
	}


	public Barco getBarco() {
		return barco;
	}


	public void setBarco(Barco barco) {
		this.barco = barco;
		barco.setCrucero(this);
	}
	
	public void unsetBarco(Barco barco) {
		this.barco = null;
		barco.setCrucero(null);
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/*
	public List<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	*/
	
	

}
