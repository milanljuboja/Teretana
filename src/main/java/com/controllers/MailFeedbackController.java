package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mail.Feedback;
import com.mail.MailService;

@RestController
@RequestMapping(value = "/mailFeedback", method = RequestMethod.GET)
public class MailFeedbackController {
	// Provereno je preko mailtrap.io
	@Autowired
	private MailService mailService;
	
	@PostMapping("/posalji")
	public void sendMail(@Valid @RequestBody Feedback feedback) {
		mailService.sendMail(feedback);
	}
}
