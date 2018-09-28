package com.example.sendemail.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void send(String nome, String emailDestinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email utilizado para envio", "senha do email"));
			email.setSSLOnConnect(true);

			email.setFrom("email utilizado para envio");
			email.setSubject("Vocçê foi convidado pelo lista vip");
			email.setMsg("Olá " + nome + "voce acaba de ser convidado");
			email.addTo(emailDestinatario);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

}
