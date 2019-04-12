package com.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "pretplate")
public class Pretplate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private long id;
	
	private Date oddatuma;
	private Date dodatuma;
	
	@JoinColumn(name = "korisnikId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	@NotNull
	private Korisnik korisnikId;
	
	@JoinColumn(name = "tippretplateId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TipPretplate tippretplateId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOddatuma() {
		return oddatuma;
	}

	public void setOddatuma(Date oddatuma) {
		this.oddatuma = oddatuma;
	}

	public Date getDodatuma() {
		return dodatuma;
	}

	public void setDodatuma(Date dodatuma) {
		this.dodatuma = dodatuma;
	}

	public Korisnik getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}

	public TipPretplate getTippretplateId() {
		return tippretplateId;
	}

	public void setTippretplateId(TipPretplate tippretplateId) {
		this.tippretplateId = tippretplateId;
	}
}
