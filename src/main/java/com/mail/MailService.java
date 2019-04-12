package com.mail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.dao.EvidencijaRepository;
import com.dao.KorisnikRepository;
import com.models.Evidencija;
import com.models.Korisnik;

@Service
public class MailService {
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private EvidencijaRepository evidencijaRepository;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void sendMail(Feedback feedback) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("milan@feedback.com");
			mailMessage.setTo(feedback.getEmail());
			mailMessage.setSubject("Nova poruka od " + feedback.getName());
			mailMessage.setText(feedback.getFeed()+ " Vasi mesecni pregledi su ");
			
			mailSender.send(mailMessage);
	}
	public void sendMailOnScheduledTime() {

		List<Korisnik> korisnik= (List<Korisnik>) korisnikRepository.findAll();
		for(Korisnik k: korisnik) {
			List<Evidencija> evidencija = new ArrayList<>();
			evidencija = evidencijaRepository.findByKorisnikId_Id(k.getId());
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("asd@feedback.com");
			mailMessage.setTo(k.getEmail());
			mailMessage.setSubject("Nova poruka od teretane");
			mailMessage.setText(" Vasi mesecni pregledi su " +evidencija.toString());
			
			// Send email
			mailSender.send(mailMessage);
		}
	}
}
