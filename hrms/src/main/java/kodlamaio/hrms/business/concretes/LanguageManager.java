package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao ;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao ;
	}
	
	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(languageDao.findById(id));
	}

}
