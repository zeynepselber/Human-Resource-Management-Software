package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguages;

@RestController
@RequestMapping("/api/resumelanguages")
public class ResumeLanguageController {

	private ResumeLanguageService resumeLanguageService ;
	
	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		this.resumeLanguageService = resumeLanguageService ;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeLanguages>> getAll(){
		return this.resumeLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeLanguages resumeLanguage) {
		return this.resumeLanguageService.add(resumeLanguage);
	}
}
