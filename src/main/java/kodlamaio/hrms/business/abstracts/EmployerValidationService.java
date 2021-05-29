package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidationService {

	String validate(Employer employer);
}
