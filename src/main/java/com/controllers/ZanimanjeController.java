package com.controllers;

import java.util.List;

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

import com.dto.ZanimanjeDTO;
import com.models.Zanimanje;
import com.services.ZanimanjeService;

@RestController
@RequestMapping(value = "/zanimanje", method = RequestMethod.GET)
public class ZanimanjeController {
	
	@Autowired
	public ZanimanjeService zanimanjeService;
	
	@GetMapping("/findAll")
	public List<Zanimanje> findAll() {
		return zanimanjeService.findAll();
	}
	
	@PostMapping("/dodaj")
	public Zanimanje addZanimanje(@Valid @RequestBody Zanimanje zanimanje) {
		return zanimanjeService.addZanimanje(zanimanje);
	}
	
	@PutMapping("/update")
	public Zanimanje updateZanimanje(@Valid @RequestBody ZanimanjeDTO zanimanjeDTO) {
		return zanimanjeService.updateZanimanje(zanimanjeDTO);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteZanimanje(@Valid @RequestBody @PathVariable long id) {
		zanimanjeService.deleteZanimanje(id);
	}
	
}
