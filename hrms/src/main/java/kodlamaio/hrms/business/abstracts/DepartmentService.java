package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Department;

public interface DepartmentService {
	DataResult<Department> getById(int id);
}
