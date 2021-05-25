package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonalService;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonalDao;
import kodlamaio.hrms.entities.concretes.SystemPersonal;

@Service
public class SystemPersonalManager implements SystemPersonalService{

	private SystemPersonalDao systemPersonalDao ;
	
	@Autowired
	public SystemPersonalManager(SystemPersonalDao systemPersonalDao) {
		this.systemPersonalDao = systemPersonalDao ;
	}
	
	@Override
	public List<SystemPersonal> getAll() {
		return systemPersonalDao.findAll();
	}

}
