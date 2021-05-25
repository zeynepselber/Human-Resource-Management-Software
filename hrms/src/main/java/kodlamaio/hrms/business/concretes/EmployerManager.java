package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerValidationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao ;
	private EmployerValidationService employerValidationService ;
	private UserService userService ;
	private ActivationService activationService ;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao , EmployerValidationService employerValidationService , 
			               UserService userService , ActivationService activationService) {
		super();
		this.employerDao = employerDao;
		this.employerValidationService = employerValidationService ;
		this.userService = userService ;
		this.activationService = activationService ;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll() , "İş Verenler listelendi.") ;			
	}

	@Override
	public Result add(Employer employer) {
		
		String message = employerValidationService.validate(employer) ;
		
		if( !message.isEmpty()) 
			return new ErrorResult(message);
		
		if( ifExistEmail( employer.getEmail()))
			return new ErrorResult("Email adresine ait başka bir kayıt mevcut.") ;
		
		employerDao.save(employer) ;
		
		activationService.emailActivation(employer.getId(), employer.getEmail());
		
		return new SuccessResult("İş veren kaydı oluşturuldu.E-postanızı kontrol ederek hesabınızı doğrulayınız.");
	}
	
	private boolean ifExistEmail(String email) {
		
		boolean result = false ;
		
		if(userService.getByEmail(email).getData() != null)
			result = true;
		
		return result ;	
	}
}
