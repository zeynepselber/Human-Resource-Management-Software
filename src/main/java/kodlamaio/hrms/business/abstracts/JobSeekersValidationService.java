package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekersValidationService {

	String validate(JobSeeker jobSeeker);
	
}
