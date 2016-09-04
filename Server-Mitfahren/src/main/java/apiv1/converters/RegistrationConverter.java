package apiv1.converters;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

import apiv1.models.request.RegisterUserModel;
import apiv1.models.response.RegisterUserResponse;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;
import helper.MailHelper;

public class RegistrationConverter {

	private MitfahrenUserService userService;
	
	public RegistrationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public RegisterUserResponse convert(RegisterUserModel userModel) {
		RegisterUserResponse response = new RegisterUserResponse();
		
		boolean usernameIsValid = userService.find(userModel.username) == null;
		boolean mailIsValid = userService.findMail(userModel.mail) == null 
				&& userModel.mail.contains("@") 
				&& userModel.mail.contains(".");
		boolean phoneIsValid = userModel.phone != "110" 
				&& userModel.phone != "112" 
				&& userService.findPhoneNumber(userModel.phone) == null;
		
		System.out.println("username is valid: " + usernameIsValid);
		System.out.println("mail is valid: " + mailIsValid);
		System.out.println("phone is valid: " + phoneIsValid);
		
		boolean registrationIsPossible = usernameIsValid && phoneIsValid && mailIsValid;
		
		if(registrationIsPossible) 
		{
			int randomActivationNum = 0 + (int)(Math.random() * 10000); 
			MitfahrenUser newUser = new MitfahrenUser(userModel.username, 
					userModel.password, userModel.phone, userModel.mail, randomActivationNum);
			userService.persists(newUser);
			
			MailHelper mailHelper = new MailHelper();
			
			
			try {
				mailHelper.sendMail(new InternetAddress("leon@brettin.de", "Mitfahren Admin"), 
						new InternetAddress(userModel.mail, userModel.username), 
						"Mitfahren Registrierung", 
						"Hallo " + userModel.username 
						+ "\nIhr Aktivierungscode ist: \n " + randomActivationNum
						+ "\nSie können ihren Code auf dieser Seite einlösen:"
						+ "mitfahren.de/activate.html");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.isRegistered = true;
			response.userId = newUser.getUserId();
		} else 
		{
			response.isRegistered = false;
			response.userId = 0;
		}
		
		return response;
	}
}
