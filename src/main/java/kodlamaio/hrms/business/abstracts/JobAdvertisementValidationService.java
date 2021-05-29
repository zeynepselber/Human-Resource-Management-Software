package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementsDto;

public interface JobAdvertisementValidationService {

	String validate(JobAdvertisementsDto jobAdvertisementDto);
}
