package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.Radnik;

@Repository
public interface RadnikRepository extends CrudRepository<Radnik, Long>{
	
	public Radnik findByEmail(String email);
	public Radnik findByEmailAndPassword(String email, String password);
	public Radnik findRadnikById(long id);
}
