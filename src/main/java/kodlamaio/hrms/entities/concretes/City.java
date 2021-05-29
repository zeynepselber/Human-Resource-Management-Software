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
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" ,  nullable = false)
	private int id;
	
	@Column(name="name" , nullable = false)
	private String name ;
	
	@OneToMany(mappedBy = "city" , fetch = FetchType.LAZY) 
	private List<JobAdvertisements> jobAdvertisements ;

	public City() {
		super();
	}
	
	public City(int id, String name, List<JobAdvertisements> jobAdvertisements) {
		super();
		this.id = id;
		this.name = name;
		this.jobAdvertisements = jobAdvertisements;
	}

	public int getId() {return id; }

	public void setId(int id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public List<JobAdvertisements> getJobAdvertisements() { return jobAdvertisements; }

	public void setJobAdvertisements(List<JobAdvertisements> jobAdvertisements) { this.jobAdvertisements = jobAdvertisements; }
	
}
