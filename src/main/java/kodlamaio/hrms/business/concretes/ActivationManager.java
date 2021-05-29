package kodlamaio.hrms.business.concretes;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.core.helpers.email.EmailService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.VarificationByEmailDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.VarificationByEmail;

@Service
public class ActivationManager implements ActivationService{

	private ActivationCodeDao activationCodeDao ;
	private VarificationByEmailDao varificationByEmailDao ;
	private EmailService emailService ;
	
	@Autowired
	public ActivationManager(ActivationCodeDao activationCodeDao, VarificationByEmailDao varificationByEmailDao , EmailService emailService) {
		super();
		this.activationCodeDao      = activationCodeDao;
		this.varificationByEmailDao = varificationByEmailDao;
		this.emailService           = emailService ;
	}

	@Override
	public void emailActivation(int userId , String email) {
	
		ActivationCode activationCode = new ActivationCode(getNewActivationCode() , false );
		activationCodeDao.save(activationCode ) ;
		
		VarificationByEmail varificationByEmail = new VarificationByEmail(userId , activationCode.getId()) ;
		varificationByEmailDao.save(varificationByEmail) ;
		
		String message = "HRMS sistemi aktivasyon linkiniz aşağıdaki gibidir. \n "+
		                 "www.localhost:8080/api/activation/verifyEmail?code="+activationCode.getCode();
		
		emailService.send(email, "Email Aktivasyon", message) ;
		
	}
	
	private String getNewActivationCode() {
		
		Random rand = new Random();
	    
	    String generatedString =  Integer.toString(rand.nextInt(999999999));  

	    return generatedString ;

	}

	@Override
	public Result verifyEmail(String code) {
		ActivationCode activationCode = activationCodeDao.findByCode(code) ;
		
		if( activationCode == null)
			return new ErrorResult("Doğrulama işlemi başarısız.");
		
		activationCode.setActivated(true);
		
		activationCodeDao.save(activationCode) ;
		
		return new SuccessResult("Doğrulama işlemi başarılı.");
		
	}

}
