package com.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "evidencija")
public class Evidencija implements Serializable {
	
	
	private static final long serialVersionUID = 5762250927513085544L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private long id;
	
	private Date datum;
	
	@JoinColumn(name = "korisnikId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Korisnik korisnikId;
	
	@JoinColumn(name = "trenerId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Trener trenerId;
	
	@JoinColumn(name = "radnikId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Radnik radnikId;
	
	public Radnik getRadnikId() {
		return radnikId;
	}

	public void setRadnikId(Radnik radnikId) {
		this.radnikId = radnikId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}

	public Trener getTrenerId() {
		return trenerId;
	}

	public void setTrenerId(Trener trenerId) {
		this.trenerId = trenerId;
	}
	
}
