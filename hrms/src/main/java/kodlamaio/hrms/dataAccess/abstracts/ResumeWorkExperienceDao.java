package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeWorkExperiences;

public interface ResumeWorkExperienceDao extends JpaRepository<ResumeWorkExperiences, Integer>{

	List<ResumeWorkExperiences> findByResume_Id(int resumeId);
}
