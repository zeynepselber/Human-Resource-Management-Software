package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface IdentityService {
	 boolean checkIfRealPerson(JobSeeker jobSeeker);
}
