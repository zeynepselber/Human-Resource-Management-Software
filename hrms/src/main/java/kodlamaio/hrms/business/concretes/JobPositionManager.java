package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll() , "İş Arayanlar listelendi") ;	
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if( jobPosition.getPositionName().isEmpty()) 
			return new ErrorResult("Lütfen pozisyon ismi giriniz.");
		
		if( ifExistPositionName(jobPosition.getPositionName()))
			return new ErrorResult("Pozisyon ismine ait başka bir kayıt mevcut.");
		
		jobPositionDao.save(jobPosition) ;
		
		return new SuccessResult("Yeni pozisyon ismi kaydı oluşturuldu.") ;
	}
	
	private boolean ifExistPositionName( String positionName) {
		boolean result = false ;
		
		if(jobPositionDao.findByPositionName(positionName) != null)
			result = true ;
		
		return result ;
	}
}
