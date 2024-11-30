package vn.iotstar.utils;

import java.util.Properties;
import java.util.Random;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vn.iotstar.models.User;


public class Email {

	String fromEmail;

	// ham ma code ngau nhien
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);

	}

	// send email to the user mail
	public boolean sendEmail(User user) {
		boolean test = false;

		String toEmail = user.getEmail();
		String fromEmail = "20146427@student.hcmute.edu.vn";
		String password = "0937275850";

		try {

			// your host email smtp server details
			Properties pr = configEmail(new Properties());

			// get Session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}

			});

			// set email message detials
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-type", "text/plain; charset = UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// set email subject
			mess.setSubject("Confirm Code");

			// set message text
			mess.setText("Your is code: " + user.getSalt());

			// send the message
			Transport.send(mess);

			test = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return test;
	}
	public boolean sendcodeUpdate(User user) {
		boolean test = false;

		String toEmail = user.getEmail();
		String fromEmail = "20146427@student.hcmute.edu.vn";
		String password = "0937275850";

		try {

			// your host email smtp server details
			Properties pr = configEmail(new Properties());

			// get Session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}

			});

			// set email message detials
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-type", "text/plain; charset = UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// set email subject
			mess.setSubject("Confirm Code");

			// set message text
			//mess.setText("Your is code: " + user.getCodeUpdate());

			// send the message
			Transport.send(mess);

			test = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return test;
	}
	
	public boolean EmailSend(User user) {
		boolean test = false;

		String toEmail = user.getEmail();
		String fromEmail = "20146427@student.hcmute.edu.vn";
		String password = "0937275850";

		try {

			// your host email smtp server details
			Properties pr = configEmail(new Properties());

			// get Session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}

			});

			// set email message detials
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-type", "text/plain; charset = UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// set email subject
			mess.setSubject("forgotpass");

			// set message text
			mess.setText("Your pass is: " + user.getHashed_password());

			// send the message
			Transport.send(mess);

			test = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return test;
	}

	private Properties configEmail(Properties pr) {
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.ssl.protocols","TLSv1.2");
        pr.put("mail.smtp.socketFactory.port", "587");
        return pr;
    }
	
}

