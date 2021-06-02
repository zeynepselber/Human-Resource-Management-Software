package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguages;

public interface ResumeProgrammingLanguageService {
	DataResult<List<ResumeProgrammingLanguages>> getAll();
	
	DataResult<List<ResumeProgrammingLanguages>> getByResumeId(int ResumeId);
		
	Result add(ResumeProgrammingLanguages resumeProgrammingLanguages);
}
