package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguages;

@RestController
@RequestMapping("/api/resumeprogramminglanguages")
public class ResumeProgrammingLanguageController {

	private ResumeProgrammingLanguageService resumeProgrammingLanguageService ;
	
	@Autowired
	public ResumeProgrammingLanguageController(ResumeProgrammingLanguageService resumeProgrammingLanguageService) {
		this.resumeProgrammingLanguageService = resumeProgrammingLanguageService ;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeProgrammingLanguages>> getAll(){
		return this.resumeProgrammingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeProgrammingLanguages resumeProgrammingLanguage) {
		return this.resumeProgrammingLanguageService.add(resumeProgrammingLanguage);
	}
}
