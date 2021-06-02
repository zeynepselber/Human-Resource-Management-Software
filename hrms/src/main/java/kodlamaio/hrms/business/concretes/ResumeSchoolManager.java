package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.business.abstracts.ResumeSchoolService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSchoolDao;
import kodlamaio.hrms.entities.concretes.ResumeSchools;

@Service
public class ResumeSchoolManager implements ResumeSchoolService{

	private ResumeSchoolDao resumeSchoolDao ;
	private ResumeService resumeService ;
	private SchoolService schoolService ;
	private DepartmentService departmentService;
	
	@Autowired
	public ResumeSchoolManager(ResumeSchoolDao resumeSchoolDao, ResumeService resumeService, 
			                   SchoolService schoolService, DepartmentService departmentService) {
		this.resumeSchoolDao = resumeSchoolDao ;
		this.resumeService = resumeService ;
		this.schoolService = schoolService ;
		this.departmentService = departmentService ;
	}
	
	@Override
	public DataResult<List<ResumeSchools>> getAll() {
		return new SuccessDataResult<List<ResumeSchools>>(resumeSchoolDao.findAll() , "Eğitim bilgileri listelendi") ;
	}

	@Override
	public DataResult<List<ResumeSchools>> getByResumeId(int ResumeId) {
		return new SuccessDataResult<List<ResumeSchools>>(resumeSchoolDao.findByResume_Id(ResumeId) , "Adayın eğitim bilgileri listelendi") ;
	}

	@Override
	public Result add(ResumeSchools resumeSchools) {
		
		if( resumeSchools.isGraduate() && resumeSchools.getFinishDate() == null)
			return new ErrorResult("Lütfen mezuniyet tarihinizi giriniz.");
		
		if( !ifExistResume(resumeSchools.getResume().getId()))
			return new ErrorResult("Böyle bir CV kaydı bulunmamaktadır.");
		
		if( !ifExistSchool(resumeSchools.getSchool().getId()))
			return new ErrorResult("Böyle bir okul kaydı bulunmamaktadır.");
		
		if( !ifExistDepartment(resumeSchools.getDepartment().getId()))
			return new ErrorResult("Böyle bir bölüm kaydı bulunmamaktadır.");
		
		resumeSchoolDao.save(resumeSchools);
		
		return new SuccessResult("Aday eğitim bilgileri kaydı oluşturuldu.");
	}

	private boolean ifExistResume(int resumeId) {
		boolean result = true ;
		
		if( resumeService.getById(resumeId).getData() == null )
			result = false ;
		
		return result ;

	}
	
	private boolean ifExistSchool(int schoolId) {
		boolean result = true ;
		
		if( schoolService.getById(schoolId).getData() == null )
			result = false ;
		
		return result ;

	}
	
	private boolean ifExistDepartment(int departmentId) {
		boolean result = true ;
		
		if( departmentService.getById(departmentId).getData() == null )
			result = false ;
		
		return result ;

	}
}
