package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeSchools;

public interface ResumeSchoolService {
	DataResult<List<ResumeSchools>> getAll();
		
	DataResult<List<ResumeSchools>> getByResumeId(int ResumeId);
		
	Result add(ResumeSchools resumeSchools);
}
