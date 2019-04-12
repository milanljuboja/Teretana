package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.Trener;

@Repository
public interface TrenerRepository extends CrudRepository<Trener, Long>{
	
	public Trener findTrainerById(long id);
}
