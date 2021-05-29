package kodlamaio.hrms.core.helpers.email;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(String to, String subject, String message) {
		return  new SuccessResult("E-posta gönderildi.");
	}

}
