package com.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.KorisnikRepository;
import com.dao.PretplateRepository;
import com.dao.TipPretplateRepository;
import com.dto.PretplateDTO;
import com.models.Pretplate;

@Service
public class PretplateService {
	
	@Autowired
	private PretplateRepository pretplateRepository;
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private TipPretplateRepository tipPretplateRepository;
	
	public Collection<Pretplate> findAll(){
		
		List<Pretplate> pretplate = new ArrayList<>();
		for(Pretplate p: pretplateRepository.findAll()) {
			pretplate.add(p);
		}
		return pretplate;
	}
	
	public Pretplate addPretplata(PretplateDTO pretplateDTO) {
		
		korisnikRepository.findById(pretplateDTO.getKorisnikId());
		tipPretplateRepository.findById(pretplateDTO.getTipPretplateId());
		
		Pretplate pretplate = new Pretplate();
		pretplate.setKorisnikId(korisnikRepository.findById(pretplateDTO.getKorisnikId()).get());
		pretplate.setTippretplateId(tipPretplateRepository.findById(pretplateDTO.getTipPretplateId()).get());
		pretplate.setOddatuma(pretplateDTO.getOddatuma());
		pretplate.setDodatuma(pretplateDTO.getDodatuma());
		
		pretplateRepository.save(pretplate);	
			
		return pretplate;
	}
		
}
