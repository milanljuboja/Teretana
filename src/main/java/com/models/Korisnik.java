package com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "korisnik")
public class Korisnik implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private long id;
	
	private String ime;
	private String prezime;
	
	@Column(name = "godrodjenja")
	private String godRodjenja;
	
	private String email;
	
	private double cena;
	
	@JoinColumn(name = "zanimanjeId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Zanimanje zanimanje;	
	
	public Zanimanje getZanimanje() {
		return zanimanje;
	}

	public void setZanimanje(Zanimanje zanimanje) {
		this.zanimanje = zanimanje;
	}

	public Korisnik() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getGodRodjenja() {
		return godRodjenja;
	}

	public void setGodRodjenja(String godRodjenja) {
		this.godRodjenja = godRodjenja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
}
