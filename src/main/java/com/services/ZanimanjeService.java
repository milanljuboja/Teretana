package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ZanimanjeRepository;
import com.dto.ZanimanjeDTO;
import com.models.Zanimanje;

@Service
public class ZanimanjeService {
	
	@Autowired
	public ZanimanjeRepository zanimanjeRepository;
	
	public List<Zanimanje> findAll(){
		
		List<Zanimanje> lista = new ArrayList<>();
		for(Zanimanje z: zanimanjeRepository.findAll()) {
			lista.add(z);
		}
		return lista;
	}
	
	public Zanimanje addZanimanje(Zanimanje zanimanje) {
		zanimanjeRepository.save(zanimanje);
		return zanimanje;
	}
	
	public Zanimanje updateZanimanje(ZanimanjeDTO zanimanjeDTO) {
		Zanimanje zanimanje = zanimanjeRepository.findByProfesija(zanimanjeDTO.getProfesija());
		zanimanje.setProfesija(zanimanjeDTO.getProfesija());
		zanimanje.setPopust(zanimanjeDTO.getPopust());
		zanimanjeRepository.save(zanimanje);
		return zanimanje;
	}
	public void deleteZanimanje(long id) {
		zanimanjeRepository.deleteById(id);
	}
}
