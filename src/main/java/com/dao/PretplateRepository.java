package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.Pretplate;

@Repository
public interface PretplateRepository extends CrudRepository<Pretplate, Long> {
	
	public List<Pretplate> findByKorisnikId_Id(long korisnikId);
}
