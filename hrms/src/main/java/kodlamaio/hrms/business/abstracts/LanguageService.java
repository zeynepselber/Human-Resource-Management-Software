package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageService {

	DataResult<Language> getById(int id);
}
