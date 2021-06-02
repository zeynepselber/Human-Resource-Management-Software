package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguages;

public interface ResumeLanguageService {
	DataResult<List<ResumeLanguages>> getAll();
	
	DataResult<List<ResumeLanguages>> getByResumeId(int ResumeId);
		
	Result add(ResumeLanguages resumeLanguages);
}
