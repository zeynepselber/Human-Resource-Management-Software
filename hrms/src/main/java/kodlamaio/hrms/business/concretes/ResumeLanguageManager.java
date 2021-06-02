package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeLanguages;

@Service
public class ResumeLanguageManager implements ResumeLanguageService{

	private ResumeLanguageDao resumeLanguageDao ;
	private ResumeService resumeService ;
	private LanguageService languageService ;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao, ResumeService resumeService, LanguageService languageService  ) {
		this.resumeLanguageDao = resumeLanguageDao ;
		this.resumeService = resumeService ;
		this.languageService = languageService ;
	}
	
	@Override
	public DataResult<List<ResumeLanguages>> getAll() {
		return new SuccessDataResult<List<ResumeLanguages>>(resumeLanguageDao.findAll() , "Konuşma dilleri listelendi") ;
	}

	@Override
	public DataResult<List<ResumeLanguages>> getByResumeId(int ResumeId) {
		return new SuccessDataResult<List<ResumeLanguages>>(resumeLanguageDao.findByResume_Id(ResumeId) , "Adayın konuşma dilleri listelendi") ;
	}

	@Override
	public Result add(ResumeLanguages resumeLanguages) {
		
		if( !ifExistResume(resumeLanguages.getResume().getId()))
			return new ErrorResult("Böyle bir CV kaydı bulunmamaktadır.");
		
		if( !ifExistLanguage(resumeLanguages.getLanguage().getId()))
			return new ErrorResult("Böyle bir konuşma dili kaydı bulunmamaktadır.");
		
		resumeLanguageDao.save(resumeLanguages);
		
		return new SuccessResult("Aday konuşma dilleri kaydı oluşturuldu.");
	}

	private boolean ifExistResume(int resumeId) {
		boolean result = true ;
		
		if( resumeService.getById(resumeId).getData() == null )
			result = false ;
		
		return result ;

	}
	
	private boolean ifExistLanguage(int languageId) {
		boolean result = true ;
		
		if( languageService.getById(languageId).getData() == null )
			result = false ;
		
		return result ;

	}
}
