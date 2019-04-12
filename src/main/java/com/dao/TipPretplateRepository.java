package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.TipPretplate;

@Repository
public interface TipPretplateRepository extends CrudRepository<TipPretplate, Long>{
	
}
