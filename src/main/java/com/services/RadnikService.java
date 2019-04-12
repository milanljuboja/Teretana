package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EvidencijaRepository;
import com.dao.RadnikRepository;
import com.models.Evidencija;
import com.models.Radnik;

@Service
public class RadnikService {
	
	@Autowired
	private RadnikRepository radnikRepository;
	@Autowired
	private EvidencijaRepository evidencijaRepository;
	
	public Radnik findByEmail(String email) {
		return radnikRepository.findByEmail(email);	
	}
	
	public Radnik createRadnik(Radnik radnik) {
		radnikRepository.save(radnik);
		return radnik;
	}
	
	public List<Evidencija> evidencijaRadnika(long id){
		
		ArrayList<Evidencija> list = new ArrayList<>();
		for(Evidencija e: evidencijaRepository.findAll()) {
			if(e.getRadnikId().getId() == id) {
				list.add(e);
			}
		}
		return list;
	}
}
