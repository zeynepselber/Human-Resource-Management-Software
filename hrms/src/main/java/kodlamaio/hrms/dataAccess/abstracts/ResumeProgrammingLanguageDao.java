package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguages;

public interface ResumeProgrammingLanguageDao extends JpaRepository<ResumeProgrammingLanguages, Integer>{
	List<ResumeProgrammingLanguages> findByResume_Id(int resumeId);
}
