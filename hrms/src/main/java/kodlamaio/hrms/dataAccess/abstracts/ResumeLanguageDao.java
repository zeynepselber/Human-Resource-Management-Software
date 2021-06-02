package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeLanguages;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguages, Integer>{
	List<ResumeLanguages> findByResume_Id(int resumeId);
}
