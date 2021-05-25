package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonalService;
import java.util.List;

import kodlamaio.hrms.entities.concretes.SystemPersonal;

@RestController
@RequestMapping("/api/systempersonals")
public class SystemPersonalsController {

	private SystemPersonalService systemPersonalService ;

	@Autowired
	public SystemPersonalsController(SystemPersonalService systemPersonalService) {
		super();
		this.systemPersonalService = systemPersonalService;
	}
	
	@GetMapping("/getall")
	public List<SystemPersonal> getAll(){
		return systemPersonalService.getAll() ;
	}
	
}
