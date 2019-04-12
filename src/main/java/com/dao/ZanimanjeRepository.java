package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.Zanimanje;

@Repository
public interface ZanimanjeRepository extends CrudRepository<Zanimanje, Long>{
	
	public Zanimanje findByProfesija(String profesija);
	public Zanimanje findZanimanjeById(long id);
}
