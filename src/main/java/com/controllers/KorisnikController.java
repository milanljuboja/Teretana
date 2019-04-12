package com.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.KorisnikCenaDTO;
import com.dto.KorisnikUpdateDTO;
import com.models.Korisnik;
import com.services.KorisnikService;

@RestController
@RequestMapping(value = "/korisnik", method = RequestMethod.GET)
public class KorisnikController {
	
	@Autowired
	private KorisnikService myService;
	
	@GetMapping("/findAll")
	public Collection<Korisnik> findAllUsers(){
		return myService.findAllUsers();
	}
	
	@PostMapping(path = "/save")
	public Korisnik createUser(@Valid @RequestBody Korisnik korisnik) {
		return myService.createUser(korisnik);
	}
	
	@PutMapping("/update")
	public Korisnik updateKorisnik(@Valid @RequestBody KorisnikUpdateDTO korisnikUpdateDTO) {
		return myService.updateKorisnik(korisnikUpdateDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteKorisnik(@Valid @RequestBody @PathVariable long id) {
		myService.deleteKorisnik(id);
	}
	@PutMapping("/korigujCenu")
	public Korisnik updateKorisnikCena(@Valid @RequestBody KorisnikCenaDTO korisnikCenaDTO) {
		return myService.updateKorisnikCena(korisnikCenaDTO);
	}
}
