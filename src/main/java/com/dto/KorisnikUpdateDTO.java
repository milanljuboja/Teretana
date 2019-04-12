package com.dto;

public class KorisnikUpdateDTO {
	
	private long id;
	private String email;
	private long zanimanjeId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getZanimanjeId() {
		return zanimanjeId;
	}
	public void setZanimanjeId(long zanimanjeId) {
		this.zanimanjeId = zanimanjeId;
	}
	
}
