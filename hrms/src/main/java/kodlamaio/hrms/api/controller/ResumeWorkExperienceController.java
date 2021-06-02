package kodlamaio.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeWorkExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ResumeWorkExperiences;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/resumeworkexperiences")
public class ResumeWorkExperienceController {

	private ResumeWorkExperienceService resumeWorkExperienceService;
	
	@Autowired
	public ResumeWorkExperienceController(ResumeWorkExperienceService resumeWorkExperienceService) {
		this.resumeWorkExperienceService = resumeWorkExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeWorkExperiences>> getAll(){
		return this.resumeWorkExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeWorkExperiences resumeWorkExperience) {
		return this.resumeWorkExperienceService.add(resumeWorkExperience);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException( MethodArgumentNotValidException exceptions){
	
		Map<String, String> validationErrors = new HashMap<String, String>() ;
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()) ;
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors , "Doğrulama hataları");
		
		return errors ;
	}
}
