package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class FakeMernisServiceAdapter implements IdentityService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;	
	}
}
