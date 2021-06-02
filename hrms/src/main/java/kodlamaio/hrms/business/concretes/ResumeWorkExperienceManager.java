package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.ResumeWorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeWorkExperienceDao;
import kodlamaio.hrms.entities.concretes.ResumeWorkExperiences;

@Service
public class ResumeWorkExperienceManager implements ResumeWorkExperienceService{

	private ResumeWorkExperienceDao resumeWorkExperienceDao ;
	private ResumeService resumeService ;
	
	@Autowired
	public ResumeWorkExperienceManager( ResumeWorkExperienceDao resumeWorkExperienceDao, ResumeService resumeService) {
		this.resumeWorkExperienceDao = resumeWorkExperienceDao ;
		this.resumeService = resumeService ;
	}
	
	@Override
	public DataResult<List<ResumeWorkExperiences>> getAll() {
		return new SuccessDataResult<List<ResumeWorkExperiences>>(resumeWorkExperienceDao.findAll() , "İş deneyimleri listelendi") ;	
	}

	@Override
	public DataResult<List<ResumeWorkExperiences>> getByResumeId(int ResumeId) {
		return new SuccessDataResult<List<ResumeWorkExperiences>>(resumeWorkExperienceDao.findByResume_Id(ResumeId) , "Adayın iş deneyimleri listelendi") ;
	}

	@Override
	public Result add(ResumeWorkExperiences resumeWorkExperiences) {
		
		if( resumeWorkExperiences.isStillWorking() && resumeWorkExperiences.getFinishDate() == null)
			return new ErrorResult("Lütfen işten ayrılma tarihinizi giriniz.");

		if( !ifExistResume(resumeWorkExperiences.getResume().getId()))
			return new ErrorResult("Böyle bir CV kaydı bulunmamaktadır.");
		
		resumeWorkExperienceDao.save(resumeWorkExperiences);
		
		return new SuccessResult("Aday iş deneyimi kaydı oluşturuldu.");
	}
	
	private boolean ifExistResume(int resumeId) {
		boolean result = true ;
		
		if( resumeService.getById(resumeId).getData() == null )
			result = false ;
		
		return result ;

	}
}
