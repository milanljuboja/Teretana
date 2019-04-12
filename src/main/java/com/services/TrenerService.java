package com.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrenerRepository;
import com.dto.TrenerDTO;
import com.models.Trener;

@Service
public class TrenerService {
	
	int brojac;
	
	@Autowired
	private TrenerRepository trenerRepository;
	
	public Collection<Trener> findAll(){
		
		List<Trener> trainers = new ArrayList<>();
		for(Trener trener: trenerRepository.findAll()) {
			trainers.add(trener);
		}
		return trainers;
	}
	
	public Trener addTrener(Trener trener) {
		trenerRepository.save(trener);
		return trener;
	}
	
	public Trener updateTrener(TrenerDTO trenerDTO) {
		Trener trener = trenerRepository.findTrainerById(trenerDTO.getId());
		trener.setCena(trenerDTO.getCena());
		trenerRepository.save(trener);
		return trener;
	}
	
	@Transactional
	public void deleteTrener(long id) {
		trenerRepository.deleteById(id);
	}
	public Trener findTrenerById(long id) {
		return trenerRepository.findTrainerById(id);
	}
}
