package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface ActivationService {

	void emailActivation(int userId , String email);
	Result verifyEmail(String code);
	
}
