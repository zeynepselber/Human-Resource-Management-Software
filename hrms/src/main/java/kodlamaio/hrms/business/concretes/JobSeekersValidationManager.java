package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersValidationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekersValidationManager implements JobSeekersValidationService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public String validate(JobSeeker jobSeeker) {
	
		String message ;
		
		if(jobSeeker.getFirstName().isEmpty()) {
			message = "Lütfen adınızı giriniz." ;
		}
		else if(jobSeeker.getLastName().isEmpty()) {
			message = "Lütfen soyadınızı giriniz." ;
		}
		else if(jobSeeker.getIdentificationNumber().isEmpty()) {
			message = "Lütfen TC numaranızı giriniz." ;
		}
		else if(jobSeeker.getYearOfBirth() == null ) {
			message = "Lütfen doğum tarihinizi giriniz.";
		}
		else if(jobSeeker.getEmail().isEmpty()){
			message = "Lütfen email adresinizi giriniz." ;
		}
		else if( !isEmailValid(jobSeeker.getEmail())) {
			message = "Lütfen geçerli bir email adresi giriniz." ;
		}
		else if(jobSeeker.getPassword().isEmpty()) {
			message = "Lütfen şifrenizi giriniz." ;
		}
		else if(jobSeeker.getPasswordRepeat().isEmpty()) {
			message = "Lütfen şifrenizi tekrar ediniz.";
		}
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
			message = "Lütfen tekrar ettiğiniz şifrenin doğruluğundan emin olunuz." ;
		}
		else
			message = "" ;
		
		return message ;
	}

	private boolean isEmailValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
	

}
