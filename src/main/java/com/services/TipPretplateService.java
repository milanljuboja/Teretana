package com.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TipPretplateRepository;
import com.models.TipPretplate;

@Service
public class TipPretplateService {
	
	@Autowired
	private TipPretplateRepository tipRepository;
	
	public Collection<TipPretplate> findAll(){
		
		List<TipPretplate> tipPretplate = new ArrayList<>();
		for(TipPretplate tip: tipRepository.findAll()) {
			tipPretplate.add(tip);
		}
		return tipPretplate;
	}
	
	public TipPretplate addPretplata(TipPretplate tp) {
		tipRepository.save(tp);
		return tp;
	}
	
	@Transactional
	public TipPretplate updatePretplata(TipPretplate tp) {
		tipRepository.save(tp);
		return tp;
	}
	
	@Transactional
	public void deletePretplata(long id) {
		tipRepository.deleteById(id);
	}
}
