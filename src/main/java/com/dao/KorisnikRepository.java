package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.models.Korisnik;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {
	
	public Korisnik findKorisnikById(long id);
	public Korisnik findKorisnikByEmail(String email);
}
