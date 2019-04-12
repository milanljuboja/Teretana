package com.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PretplateDTO;
import com.models.Pretplate;
import com.services.PretplateService;

@RestController
@RequestMapping(value = "/pretplate", method = RequestMethod.GET)
public class PretplateController {
	
	@Autowired
	private PretplateService svePretplateService;
	
	@GetMapping("/svePretplate")
	public Collection<Pretplate> findAll(){
		return svePretplateService.findAll();
	}
	
	@PostMapping("/dodaj")
	public Pretplate addPretplata(@Valid @RequestBody PretplateDTO pretplateDTO) {
		return svePretplateService.addPretplata(pretplateDTO);
	}
}
