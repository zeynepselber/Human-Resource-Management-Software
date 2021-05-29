package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerValidationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerValidationManager implements EmployerValidationService{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public String validate(Employer employer) {
		
		String message ;
		
		if(employer.getCompanyName().isEmpty()) {
			message = "Lütfen şirket adınızı giriniz." ;
		}
		else if(employer.getWebsite().isEmpty()) {
			message = "Lütfen web sitenizi giriniz." ;
		}
		else if(employer.getPhone().isEmpty()) {
			message = "Lütfen telefonunuzu giriniz." ;
		}
		else if(employer.getEmail().isEmpty()){
			message = "Lütfen email adresinizi giriniz." ;
		}
		else if( !isEmailValid(employer.getEmail())) {
			message = "Lütfen geçerli bir email adresi giriniz." ;
		}
		else if( !isSameDomain(employer)) {
			message = "Lütfen websiteniz ile aynı domaine sahip bir email adresi giriniz." ;
		}
		else if(employer.getPassword().isEmpty()) {
			message = "Lütfen şifrenizi giriniz." ;
		}
		else if(employer.getPasswordRepeat().isEmpty()) {
			message = "Lütfen şifrenizi tekrar ediniz.";
		}
		else if(!employer.getPassword().equals(employer.getPasswordRepeat())) {
			message = "Lütfen tekrar ettiğiniz şifrenin doğruluğundan emin olunuz." ;
		}
		else
			message = "" ;
		
		return message ;
	}
	
	private boolean isEmailValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
	
	private boolean isSameDomain(Employer employer) {
		
		boolean result = false ;
		
		String email        = employer.getEmail();
		String[] emailSplit = email.split("@");
		
		String website        = employer.getWebsite();
		String[] websiteSplit = website.split("www.");
		
		if(emailSplit[1].equals(websiteSplit[1])) 
			result = true;
		
		return result;
	}
}
