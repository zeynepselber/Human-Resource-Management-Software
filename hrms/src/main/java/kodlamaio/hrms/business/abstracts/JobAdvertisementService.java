package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementsDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisements>> findByIsActiveTrue(); 
	
	DataResult<List<JobAdvertisements>> findByIsActiveTrueOrderByCreateDate(); 
	
	DataResult<List<JobAdvertisements>> findByIsActiveTrueByEmployer_Id(int employerId); 
	
	Result add(JobAdvertisementsDto jobAdvertisementsDto);
	
	Result chengeStatus(int jobAdvertisementId , int employerId);
}
