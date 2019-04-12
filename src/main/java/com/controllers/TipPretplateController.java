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

import com.models.TipPretplate;
import com.services.TipPretplateService;

@RestController
@RequestMapping(value = "/tippretplate", method = RequestMethod.GET)
public class TipPretplateController {
	
	@Autowired
	private TipPretplateService tipService;
	
	@GetMapping("/findAll")
	public Collection<TipPretplate> findAllSubscriptions(){
		return tipService.findAll();
	}
	
	@PostMapping(path = "/ubaci")
	public TipPretplate addPretplata(@Valid @RequestBody TipPretplate tp) {
		return tipService.addPretplata(tp);
	}
	
	@PutMapping("/update")
	public TipPretplate updatePretplata(@Valid @RequestBody TipPretplate tp) {
		return tipService.updatePretplata(tp);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePretplata(@Valid @RequestBody @PathVariable long id) {
		tipService.deletePretplata(id);
	}
}
