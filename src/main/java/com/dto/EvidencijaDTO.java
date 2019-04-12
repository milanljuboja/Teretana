package com.dto;

import java.sql.Date;

public class EvidencijaDTO {
	
	private Date datum;
	private Long korisnikId;
	private Long trenerId;
	private Long radnikId;
	
	public Long getRadnikId() {
		return radnikId;
	}
	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	public Long getTrenerId() {
		return trenerId;
	}
	public void setTrenerId(Long trenerId) {
		this.trenerId = trenerId;
	}
	
}
