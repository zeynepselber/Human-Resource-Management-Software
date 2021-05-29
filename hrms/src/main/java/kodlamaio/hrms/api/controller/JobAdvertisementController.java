package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementsDto;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService ;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService ;
	}
	
	@GetMapping("getAllActive")
	public DataResult<List<JobAdvertisements>> getallActive(){
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("getAllActiveOrderByDate")
	public DataResult<List<JobAdvertisements>> getAllActiveOrderByDate(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderByCreateDate();
	}
	
	@GetMapping("getAllActiveByEmployer")
	public DataResult<List<JobAdvertisements>> getAllActiveByEmployer(int employerId){
		return this.jobAdvertisementService.findByIsActiveTrueByEmployer_Id(employerId) ;
	}
	
	@PutMapping("changeStatus")
	public Result changeStatus( int jobAdvertisementId , int employerId) {
		return jobAdvertisementService.chengeStatus(jobAdvertisementId, employerId) ;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisementsDto jobAdvertisementDto) {
		return jobAdvertisementService.add(jobAdvertisementDto) ;
	}
}
