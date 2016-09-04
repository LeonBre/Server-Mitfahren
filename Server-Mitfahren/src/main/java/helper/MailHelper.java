package helper;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class MailHelper {

	static final String smtpServer = "smtp.web.de";
	static final String smtpPort = "587";
	static final String EmailUser = "GamboPower";
	static final String EmailPassword = "";
	
	/**
	 * Sendet eine Mail 
	 * @param fromAddress 	= Adresse des Absenders 	z.B. gambopower@web.de
	 * @param toAddress 	= Adresse des Empfängers	z.B. leon@brettin.de
	 * @param msgSubject	= Betreff					z.B. Dies ist ein Test
	 * @param msgBody		= Mailinhalt				z.B. Dies ist der Inhalt der Mail
	 * 
	 * Bei dem Fehler hier:
	 * 535 Authentication credentials invalid
	 * Muss man PoP3/Imap noch aktivieren, wurde hier für web.de erklärt:
	 * http://forum.ipfire.org/viewtopic.php?t=13253
	 */
	public void sendMail(InternetAddress fromAddress, InternetAddress toAddress, String msgSubject, String msgBody){
		try {
			Properties props =  new Properties();
			props.put("mail.smtp.host", smtpServer);		
			props.put("mail.smtp.port", smtpPort);
			props.put("mail.smtp.ssl.trust", smtpServer);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.connectiontimeout", "10000");


			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					  protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
							EmailUser,EmailPassword);
					     }
				   });

			session.setDebug(true);	
			
			Message msg = new MimeMessage(session);
			msg.setFrom(fromAddress);
			msg.addRecipient(Message.RecipientType.TO,toAddress);
			msg.setSubject(msgSubject);
			msg.setText(msgBody);

			Transport transport = session.getTransport("smtp");
			transport.connect();
			transport.sendMessage(msg, msg.getAllRecipients());
			   
		   }
		   catch (MessagingException e) {
			System.out.println(e.getMessage()+ e.getStackTrace());
		   }
	 }
	
	/**
	 * Beispielaufruf:
	 */
	private void exampleUsage(){
		MailHelper email = new MailHelper();
		
		try{
		
		InternetAddress fromAddress = new InternetAddress("gambopower@web.de",
								"GamboPower");
		InternetAddress toAddress = new InternetAddress("leon@brettin.de",
								"Leon");
		String msgSubject = "TestMail";
		String msgBody = "Blablabla, drücke bitte auf diesen link: www.google.com um deinen Account"
				+ " zu bestätigen, blablablabla";
		
		email.sendMail(fromAddress, toAddress, msgSubject, msgBody);
		
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}

	}
}
