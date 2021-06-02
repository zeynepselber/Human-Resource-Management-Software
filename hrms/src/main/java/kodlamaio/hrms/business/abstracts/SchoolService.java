package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<School> getById(int id);
}
