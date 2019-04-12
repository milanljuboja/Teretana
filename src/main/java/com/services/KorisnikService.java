package com.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.KorisnikRepository;
import com.dao.PretplateRepository;
import com.dao.ZanimanjeRepository;
import com.dto.KorisnikCenaDTO;
import com.dto.KorisnikUpdateDTO;
import com.models.Korisnik;
import com.models.Pretplate;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private PretplateRepository pretplateRepository;
	@Autowired
	private ZanimanjeRepository zanimanjeRepository;
	
	public Collection<Korisnik> findAllUsers(){
		
		List<Korisnik> korisnik = new ArrayList<>();
		for(Korisnik k: korisnikRepository.findAll()) {
			korisnik.add(k);
		}
		return korisnik;
	}
	
	public Korisnik createUser(Korisnik korisnik) {
		korisnikRepository.save(korisnik);
		return korisnik;
	}
	
	public Korisnik updateKorisnik(KorisnikUpdateDTO korisnikUpdateDTO) {
		Korisnik korisnik = korisnikRepository.findKorisnikById(korisnikUpdateDTO.getId());
		korisnik.setEmail(korisnikUpdateDTO.getEmail());
		korisnik.setZanimanje(zanimanjeRepository.findZanimanjeById(korisnikUpdateDTO.getZanimanjeId()));
		korisnikRepository.save(korisnik);
		return korisnik;
	}
	
	@Transactional
	public void deleteKorisnik(long id) {
		korisnikRepository.deleteById(id);
	}
	
	public Korisnik updateKorisnikCena(KorisnikCenaDTO korisnikCenaDTO) {
		Korisnik korisnik = korisnikRepository.findKorisnikByEmail(korisnikCenaDTO.getEmail());
		List<Pretplate> svePretplate = pretplateRepository.findByKorisnikId_Id(korisnik.getId());
		Pretplate pretplata = svePretplate.get(svePretplate.size()-1);
		if(korisnik.getZanimanje() != null) {
			korisnik.setCena(pretplata.getTippretplateId().getCena() - (pretplata.getTippretplateId().getCena()*korisnik.getZanimanje().getPopust()/100));
		}
		else {
			korisnik.setCena(pretplata.getTippretplateId().getCena());
		}
		
		korisnikRepository.save(korisnik);
		return korisnik;
	}
}
