package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementValidationService;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementsDto;

@Service
public class JobAdvertisementValidationManager implements JobAdvertisementValidationService{

	@Override
	public String validate(JobAdvertisementsDto jobAdvertisementDto) {
	
		System.out.println(jobAdvertisementDto);
		String message = "" ;
		
		if( jobAdvertisementDto.getDescription().isEmpty())
			message = "Lütfen iş ilan içeriğini giriniz." ;
		else if(jobAdvertisementDto.getEmployerId() == 0 )
			message = "Lütfen firma seçiniz." ;
		else if(jobAdvertisementDto.getJobPositionId() == 0 )
			message = "Lütfen iş pozisyonu seçiniz." ;
		else if(jobAdvertisementDto.getCityId() == 0  )
			message = "Lütfen şehir seçiniz." ;
		/*else if(jobAdvertisementDto.getLastApplyDate() == null )
			message = "Lütfen son başvuru tarihini giriniz." ;*/
		else if(jobAdvertisementDto.getOpenPositionCount() == 0  )
			message = "Lütfen açık iş pozisyonu adeti giriniz." ;
		
		return message ;
	}

}
