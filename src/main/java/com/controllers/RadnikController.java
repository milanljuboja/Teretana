package com.controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RadnikDTO;
import com.models.Evidencija;
import com.models.Radnik;
import com.security.LoginService;
import com.services.RadnikService;

@Api(description = "", name = "")
@RestController
@RequestMapping(value = "/radnik", method = RequestMethod.GET)
public class RadnikController {
	
	@Autowired
	private RadnikService radnikService;
	@Autowired
	private LoginService loginService;
	@Autowired
	public RadnikController(LoginService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping(value = "/kreiraj", method = RequestMethod.POST)
	public Radnik createRadnik(Radnik radnik) {
		return radnikService.createRadnik(radnik);
	}
	
	@GetMapping("/upisiRadnika/{id}")
	public List<Evidencija> evidencijaRadnika(@Valid @RequestBody @PathVariable long id){
		return radnikService.evidencijaRadnika(id);
	}
	
    @ApiMethod(description="login")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody RadnikDTO radnikDTO) throws ServletException {
		return loginService.authorize(radnikDTO);
	}
}