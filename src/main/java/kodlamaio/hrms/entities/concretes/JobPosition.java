package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})
public class JobPosition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id ;
	
	@Column(name="position_name" , nullable = false)
	private String positionName ;
	
	@OneToMany(mappedBy = "jobPosition" , fetch = FetchType.LAZY) 
	private List<JobAdvertisements> jobAdvertisements ;
	
	public JobPosition() {}

	public JobPosition(String positionName) {
		this.positionName = positionName;
	}
	
	public JobPosition(int id, String positionName , List<JobAdvertisements> jobAdvertisements) {
		this.id = id;
		this.positionName = positionName;
		this.jobAdvertisements = jobAdvertisements ;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getPositionName() { return positionName; }

	public void setPositionName(String positionName) { this.positionName = positionName; }
	
	public List<JobAdvertisements> getJobAdvertisements() { return jobAdvertisements; }

	public void setJobAdvertisements(List<JobAdvertisements> jobAdvertisements) { this.jobAdvertisements = jobAdvertisements; }
 
}
