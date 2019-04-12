package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.Evidencija;

@Repository
public interface EvidencijaRepository extends CrudRepository<Evidencija, Long>{
	
	public List<Evidencija> findByKorisnikId_Id (Long korisnikId);
}
