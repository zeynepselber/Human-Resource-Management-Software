package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.JobSeekersValidationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.IdentityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao ;
	private JobSeekersValidationService jobSeekersValidationService  ;
	private IdentityService identityService ;
	private UserService userService ;
	private ActivationService activationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao , JobSeekersValidationService jobSeekersValidationService , 
			                UserService userService,    IdentityService identityService ,  
			                ActivationService activationService) {
		super();
		this.jobSeekerDao                = jobSeekerDao;
		this.jobSeekersValidationService = jobSeekersValidationService ;
		this.identityService             = identityService ;
		this.userService                 = userService ;
		this.activationService           = activationService ;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll() , "İş Arayanlar listelendi") ;			
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		
		String message = jobSeekersValidationService.validate(jobSeeker) ;
		
		if( !message.isEmpty()) 
			return new ErrorResult(message);
		
		if( ifExistIdentificationNumber( jobSeeker.getIdentificationNumber()))
			return new ErrorResult("TC numarasına ait başka bir kayıt mevcut.") ;
		
		if( !( identityService.checkIfRealPerson(jobSeeker))) 
			return new ErrorResult("TC numara doğrulama başarısız.") ;
		
		if( ifExistEmail( jobSeeker.getEmail()))
			return new ErrorResult("Email adresine ait başka bir kayıt mevcut.") ;
		
		jobSeekerDao.save(jobSeeker) ;
			
		activationService.emailActivation(jobSeeker.getId(), jobSeeker.getEmail());
			
		return  new SuccessResult("İş arayan kaydı oluşturuldu.E-postanızı kontrol ederek hesabınızı doğrulayınız.");
		
	}
	
	private boolean ifExistIdentificationNumber( String identificationNumber) {
		boolean result = false ;
		
		if(jobSeekerDao.findByIdentificationNumber(identificationNumber) != null)
			result = true ;
		
		return result ;
	}

	private boolean ifExistEmail(String email) {
		
		boolean result = false ;
		
		if(userService.getByEmail(email).getData() != null)
			result = true;
		
		return result ;
	}
}
