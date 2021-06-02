package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	DataResult<ProgrammingLanguage> getById(int id);
}
