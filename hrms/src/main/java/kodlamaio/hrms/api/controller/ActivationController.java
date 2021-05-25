package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activation")
public class ActivationController {

	private ActivationService activationService ;
	
	@Autowired
	public ActivationController(ActivationService activationService) {
		this.activationService = activationService ;
	}
	
	@PostMapping("/verifyEmail")
	public Result verifyEmail(String code) {
		return activationService.verifyEmail(code) ;
	}
	
}
