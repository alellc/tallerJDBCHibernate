package org.springframework.samples.petclinic.owner;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.springframework.samples.petclinic.visit.Visit;


@Entity
@Table(name="facturas")
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Digits(integer=10,fraction=0)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Digits(integer=10,fraction=2)
	private double precio;
	
//	@ManyToOne
//	@JoinColumn(name="Owner")
//	private Owner owner;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="bill",cascade=CascadeType.ALL)
	private Visit visit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

//	public Owner getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Owner owner) {
//		this.owner = owner;
//	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
}
