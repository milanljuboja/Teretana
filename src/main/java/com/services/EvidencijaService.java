package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EvidencijaRepository;
import com.dao.KorisnikRepository;
import com.dao.RadnikRepository;
import com.dao.TrenerRepository;
import com.dto.EvidencijaDTO;
import com.models.Evidencija;
import com.models.Korisnik;
import com.models.Trener;

@Service
public class EvidencijaService {
	
	@Autowired
	private EvidencijaRepository evidencijaRepository;
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private TrenerRepository trenerRepository;
	@Autowired
	private TrenerService trenerService;
	@Autowired
	private RadnikRepository radnikRepository;
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	public List<Evidencija> findAll(){
		
		List<Evidencija> evidencija = new ArrayList<>();
		for(Evidencija e: evidencijaRepository.findAll()) {
			evidencija.add(e);
		}
		return evidencija;
	}
	
	public Evidencija addEvidencija(EvidencijaDTO evidencijaDTO, String email) {
		Evidencija evidencija = new Evidencija();
		email = (String) httpServletRequest.getAttribute("OPERATER_MAIL");
		
		evidencija.setDatum(evidencijaDTO.getDatum());
		evidencija.setKorisnikId(korisnikRepository.findKorisnikById(evidencijaDTO.getKorisnikId()));
		evidencija.setTrenerId(trenerRepository.findTrainerById(evidencijaDTO.getTrenerId()));
		evidencija.setRadnikId(radnikRepository.findByEmail(email));
		evidencijaRepository.save(evidencija);
		
		Trener trener = trenerService.findTrenerById(evidencijaDTO.getTrenerId());
		
//		if(trener.getEvidencije().size()%2 == 0) {
//			trener.setCena(trener.getCena()*2);
//		}
//		trenerRepository.save(trener);
		
		if(trener != null) {
			int brojac = trener.getBrojTermina();
			brojac++;
			trener.setBrojTermina(brojac);
			if(brojac%2 == 0) {
				trener.setCena(trener.getCena()*2);
			}
			trenerRepository.save(trener);
		}
		return evidencija;
	}
	public List<Evidencija> findKorisnikById(long id){
		
		Korisnik korisnik;
		
		List<Evidencija> evidencija = new ArrayList<>();
		for(Evidencija e: evidencijaRepository.findAll()) {
			korisnik = e.getKorisnikId();
			if(korisnik.getId() == id)
				evidencija.add(e);
		}
		return evidencija;
	}
	
}
