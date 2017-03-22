package org.springframework.samples.petclinic.owner;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;
@Entity
@Table(name="cuenta")
public class Cuenta extends BaseEntity {
	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="password",unique=true)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:MM:ss")
    private Date date;

	@OneToOne(fetch=FetchType.LAZY,mappedBy="cuenta",cascade=CascadeType.ALL)
	private Owner owner;
	
	public String getUsername() {
		return username;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
