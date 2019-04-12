package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EvidencijaDTO;
import com.models.Evidencija;
import com.services.EvidencijaService;

@RestController
@RequestMapping(value = "/evidencija", method = RequestMethod.GET)
@Api(name = "Evidencija API", description="Lista metoda za celu evidenciju iz teretane", stage = ApiStage.RC)
public class EvidencijaController {
	
	@Autowired
	private EvidencijaService evidencijaService;
	
	@GetMapping("/allRecords")
	@ApiMethod(description = "Dohvata sve evidencije iz teretane")
	public List<Evidencija> findAll(){
		return evidencijaService.findAll();
	}
	
	@PostMapping("/dodaj")
	@ApiMethod(description = "Dodaje novu evidenciju")
	public Evidencija addEvidencija(@Valid @RequestBody EvidencijaDTO evidencijaDTO, HttpServletRequest httpServletRequest) {
		String email = (String) httpServletRequest.getAttribute("OPERATER_MAIL");
		return evidencijaService.addEvidencija(evidencijaDTO, email);
	}
	
	@GetMapping("/findById/{id}")
	@ApiMethod(description = "Pronalazi sve evidencije za zeljenog korisnika")
	public List<Evidencija> findKorisnikById(@ApiPathParam(name = "id") @Valid @RequestBody @PathVariable long id) {
		return evidencijaService.findKorisnikById(id);
	}
}
