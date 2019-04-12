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

import com.dto.TrenerDTO;
import com.models.Trener;
import com.services.TrenerService;

@RestController
@RequestMapping(value = "/trener", method = RequestMethod.GET)
public class TrenerController {
	
	@Autowired
	private TrenerService trainerService;
	
	@GetMapping("/findAll")
	public Collection<Trener> findAll(){
		return trainerService.findAll();
	}
	
	@PostMapping("/save")
	public Trener addTrener(@Valid @RequestBody Trener trener) {
		trainerService.addTrener(trener);
		return trener;
	}
	
	@PutMapping("/update")
	public Trener updateTrener(@Valid @RequestBody TrenerDTO trenerDTO) {
		return trainerService.updateTrener(trenerDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTrener(@RequestBody @PathVariable long id) {
		trainerService.deleteTrener(id);
	}
}
