package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementValidationService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementsDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementsDao jobAdvertisementsDao;
	private EmployerService employerService ;
	private JobPositionService jobPositionService ;
	private CityService cityService ;
	private JobAdvertisementValidationService jobAdvertisementValidationService;
	 
	@Autowired
    public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao , EmployerService employerService , 
    		                       JobPositionService jobPositionService , CityService cityService ,
    		                       JobAdvertisementValidationService jobAdvertisementValidationService) {
		this.jobAdvertisementsDao = jobAdvertisementsDao ;
		this.employerService      = employerService ;
		this.jobPositionService   = jobPositionService;
		this.cityService          = cityService ;
		this.jobAdvertisementValidationService = jobAdvertisementValidationService ;
		
	}
	@Override
	public DataResult<List<JobAdvertisements>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisements>>(jobAdvertisementsDao.findByIsActiveTrue() , "Tüm aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisements>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisements>>(jobAdvertisementsDao.findByIsActiveTrueOrderByCreateDate() , "Tüm aktif iş ilanları tarihe göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisements>> findByIsActiveTrueByEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisements>>(jobAdvertisementsDao.findByIsActiveTrueAndEmployer_Id(employerId) , "Firmaya ait tüm aktif iş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisementsDto jobAdvertisementDto) {
		
		String message = jobAdvertisementValidationService.validate(jobAdvertisementDto) ;
		
		if( !message.isEmpty())
			return new ErrorResult(message) ;
		
		if( !ifExistCityId(jobAdvertisementDto.getCityId()))
			return new ErrorResult("Girilen şehir bilgisine ait kayıt bulunmamaktadır.") ;
		
		if( !ifExistEmployerId(jobAdvertisementDto.getEmployerId()))
			return new ErrorResult("Girilen firma bilgisine ait kayıt bulunmamaktadır.");
		
		if( !ifExistjobPositionId(jobAdvertisementDto.getJobPositionId()))
			return new ErrorResult("Girilen iş pozisyona ait kayıt bulunmamaktadır.");
		
		JobAdvertisements jobAdvertisement = new JobAdvertisements( 
				jobAdvertisementDto.getDescription(), jobAdvertisementDto.getMinSalary(), jobAdvertisementDto.getMaxSalary(),
				jobAdvertisementDto.getOpenPositionCount(), jobAdvertisementDto.isActive(), jobAdvertisementDto.getLastApplyDate(),
				LocalDate.now() );
		
		jobAdvertisement.setEmployer(employerService.getById(jobAdvertisementDto.getEmployerId()).getData());
		jobAdvertisement.setJobPosition(jobPositionService.getById(jobAdvertisementDto.getJobPositionId()).getData());
		jobAdvertisement.setCity(cityService.getById(jobAdvertisementDto.getCityId()).getData());
		
		jobAdvertisementsDao.save(jobAdvertisement) ;
		
		
		
		return new SuccessResult("iş ilanı kaydı oluşturuldu.");
	}

	@Override
	public Result chengeStatus(int jobAdvertisementId, int employerId) {
		
		JobAdvertisements jobAdvertisement = jobAdvertisementsDao.findByIdAndEmployer_Id(jobAdvertisementId, employerId) ;
		
		if( jobAdvertisement == null )
			return new ErrorResult("Firmaya ait böyle bir iş ilanı bulunmamaktadır.");
		
		jobAdvertisement.setActive(!jobAdvertisement.isActive());
		
		jobAdvertisementsDao.save(jobAdvertisement) ;
		
		String message = jobAdvertisement.isActive() ? "İş ilanı aktif." : "İş ilanı pasif.";
		
		return new SuccessResult(message);
	}
	
	private boolean ifExistEmployerId(int employerId) {
		boolean result = true ;
		
		if( employerService.getById(employerId).getData() == null )
			result = false ;
		
		return result ;
	}
	
	private boolean ifExistjobPositionId(int jobPositionId) {
		boolean result = true ;
		
		if( jobPositionService.getById(jobPositionId).getData() == null )
			result = false ;
		
		return result ;
	}
	
	private boolean ifExistCityId(int cityId) {
		boolean result = true ;
		
		if( cityService.getById(cityId).getData() == null )
			result = false ;
		
		return result ;
	}

}
