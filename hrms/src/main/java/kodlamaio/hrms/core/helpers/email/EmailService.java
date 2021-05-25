package kodlamaio.hrms.core.helpers.email;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {

	Result send(String to , String subject , String message);
}
