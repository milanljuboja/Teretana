package com.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "trener")
public class Trener implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private long id;
	
	private String ime;
	private String prezime;
	private int cena;
	
	@Column(name = "brojtermina")
	private int brojTermina;
	
	@JsonBackReference
	@OneToMany(mappedBy = "trenerId")
	private List<Evidencija> evidencije;
	
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
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	
	public List<Evidencija> getEvidencije() {
		return evidencije;
	}
	
	public void setEvidencije(List<Evidencija> evidencije) {
		this.evidencije = evidencije;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getBrojTermina() {
		return brojTermina;
	}
	public void setBrojTermina(int brojTermina) {
		this.brojTermina = brojTermina;
	}
}
