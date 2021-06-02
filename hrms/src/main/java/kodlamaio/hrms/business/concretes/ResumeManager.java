package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.helpers.image.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao ;
	private ImageService imageService;
	
	@Autowired
	public ResumeManager( ResumeDao resumeDao, ImageService imageService ) {
		this.resumeDao = resumeDao;
		this.imageService = imageService ;
	}
	
	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Yeni CV kaydı oluşturuldu.");
	}

	@Override
	public DataResult<List<Resume>> findByJobSeeker_Id(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(resumeDao.findByJobSeeker_Id(jobSeekerId) , "Adaya ait CV bilgisi görüntülenmektedir.");
	}

	@Override
	public Result addImage(int resumeId, MultipartFile file) {
		
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		
		Resume resume = this.resumeDao.getOne(resumeId);
		resume.setImage(result.get("url"));
		
		this.resumeDao.save(resume);
		
		return new SuccessResult("Adayın foroğrafı başarıyla eklendi.");
		
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(resumeDao.findById(id));
	}
}
