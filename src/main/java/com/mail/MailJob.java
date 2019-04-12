package com.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailJob{
	
	@Autowired
	private MailService mailService;
	
	@Scheduled(cron="0 0 0 1 1/1 *")
	public void execute() {
        mailService.sendMailOnScheduledTime();
    }
	
	//@Scheduled(fixedDelay=2000)
	public void test() {
        mailService.sendMailOnScheduledTime();
    }
}
