package com.dto;

import java.sql.Date;

public class PretplateDTO {
	
	private Long korisnikId;
	private Long tipPretplateId;
	private Date oddatuma;
	private Date dodatuma;
	
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	public Long getTipPretplateId() {
		return tipPretplateId;
	}
	public void setTipPretplateId(Long tipPretplateId) {
		this.tipPretplateId = tipPretplateId;
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
}
