package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.ResumeProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguages;
import kodlamaio.hrms.entities.concretes.ResumeSchools;

@Service
public class ResumeProgrammingLanguageManager implements ResumeProgrammingLanguageService{

	private ResumeProgrammingLanguageDao resumeProgrammingLanguageDao ;
	private ResumeService resumeService ;
	private ProgrammingLanguageService programmingLanguageService ;
	
	@Autowired
	public ResumeProgrammingLanguageManager(ResumeProgrammingLanguageDao resumeProgrammingLanguageDao,
			                                ResumeService resumeService, 
			                                ProgrammingLanguageService programmingLanguageService  ) {
		this.resumeProgrammingLanguageDao = resumeProgrammingLanguageDao ;
		this.resumeService = resumeService ;
		this.programmingLanguageService = programmingLanguageService ;
		
	}
	
	@Override
	public DataResult<List<ResumeProgrammingLanguages>> getAll() {
		return new SuccessDataResult<List<ResumeProgrammingLanguages>>(resumeProgrammingLanguageDao.findAll() , "Programlama dilleri listelendi") ;
	}

	@Override
	public DataResult<List<ResumeProgrammingLanguages>> getByResumeId(int ResumeId) {
		return new SuccessDataResult<List<ResumeProgrammingLanguages>>(resumeProgrammingLanguageDao.findByResume_Id(ResumeId) , "Aday??n Programlama dilleri listelendi") ;
	}

	@Override
	public Result add(ResumeProgrammingLanguages resumeProgrammingLanguages) {
		
		if( !ifExistResume(resumeProgrammingLanguages.getResume().getId()))
			return new ErrorResult("B??yle bir CV kayd?? bulunmamaktad??r.");
		
		if( !ifExistProgrammingLanguage(resumeProgrammingLanguages.getProgrammingLanguage().getId()))
			return new ErrorResult("B??yle bir programlama dili kayd?? bulunmamaktad??r.");
		
		resumeProgrammingLanguageDao.save(resumeProgrammingLanguages);
		
		return new SuccessResult("Aday programlama dilleri kayd?? olu??turuldu.");
		
	}
	
	private boolean ifExistResume(int resumeId) {
		boolean result = true ;
		
		if( resumeService.getById(resumeId).getData() == null )
			result = false ;
		
		return result ;

	}
	
	private boolean ifExistProgrammingLanguage(int languageId) {
		boolean result = true ;
		
		if( programmingLanguageService.getById(languageId).getData() == null )
			result = false ;
		
		return result ;

	}

}
