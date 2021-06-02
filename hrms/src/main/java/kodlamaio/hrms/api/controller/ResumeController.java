package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes/")
public class ResumeController {

	private ResumeService resumeService ;
	
	@Autowired
	public ResumeController(ResumeService resumeService) {
		this.resumeService = resumeService ;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@PostMapping("addImage")
	public Result add(@RequestParam int resumeId,@RequestParam MultipartFile file ) {
		return this.resumeService.addImage(resumeId,file);
	}
	
	@GetMapping("findByJobSeekerId")
	public DataResult<List<Resume>> findByJobSeekerId(int jobSeekerId){
		return this.resumeService.findByJobSeeker_Id(jobSeekerId);
	}
}
