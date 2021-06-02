package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeSchools;

@RestController
@RequestMapping("/api/resumeschools")
public class ResumeSchoolController {

	private ResumeSchoolService resumeSchoolService;
	
	@Autowired
	public ResumeSchoolController(ResumeSchoolService resumeSchoolService) {
		this.resumeSchoolService = resumeSchoolService ;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeSchools>> getAll(){
		return this.resumeSchoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeSchools resumeWorkExperience) {
		return this.resumeSchoolService.add(resumeWorkExperience);
	}
}
