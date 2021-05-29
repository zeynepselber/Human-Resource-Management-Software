package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisements;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements, Integer>{

	List<JobAdvertisements> findByIsActiveTrue(); // all active job advertisements
	
	List<JobAdvertisements> findByIsActiveTrueOrderByCreateDate(); // all active job advertisements order by date
	
	List<JobAdvertisements> findByIsActiveTrueAndEmployer_Id(int employerId); // all active job advertisements by employer
	
	JobAdvertisements findByIdAndEmployer_Id(int id , int employerId);
}
