package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_advertisements")
public class JobAdvertisements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id;
	
	@Column(name="description" , nullable = false)
	private String description;
	
	@Column(name="min_salary" , nullable = true)
	private double minSalary;
	
	@Column(name="max_salary" , nullable = false)
	private double maxSalary;
	
	@Column(name="open_position_count" , nullable = false)
	private int openPositionCount ;
	
	@Column(name="is_active" , nullable = false)
	private boolean isActive ;
	
	@Column(name="last_apply_date" , nullable = false)
	private LocalDate lastApplyDate;
	
	@Column(name="create_date" , nullable = false)
	private LocalDate createDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="city_id")
	private City city ;

	public JobAdvertisements() {
		super();
	}

	public JobAdvertisements(String description, double minSalary, double maxSalary, int openPositionCount,
            boolean isActive, LocalDate lastApplyDate, LocalDate createDate) {
			super();
			this.description       = description;
			this.minSalary         = minSalary;
			this.maxSalary         = maxSalary;
			this.openPositionCount = openPositionCount;
			this.isActive          = isActive;
			this.lastApplyDate     = lastApplyDate;
			this.createDate        = createDate;
	}
	
	public JobAdvertisements(int id, String description, double minSalary, double maxSalary, int openPositionCount,
			                 boolean isActive, LocalDate lastApplyDate, LocalDate createDate, 
			                 Employer employer, JobPosition jobPosition, City city) {
		super();
		this.id = id;
		this.description       = description;
		this.minSalary         = minSalary;
		this.maxSalary         = maxSalary;
		this.openPositionCount = openPositionCount;
		this.isActive          = isActive;
		this.lastApplyDate     = lastApplyDate;
		this.createDate        = createDate;
		this.employer          = employer;
		this.jobPosition       = jobPosition;
		this.city              = city;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public double getMinSalary() { return minSalary; }

	public void setMinSalary(double minSalary) { this.minSalary = minSalary; }

	public double getMaxSalary() { return maxSalary; }

	public void setMaxSalary(double maxSalary) { this.maxSalary = maxSalary; }

	public int getOpenPositionCount() { return openPositionCount; }

	public void setOpenPositionCount(int openPositionCount) { this.openPositionCount = openPositionCount; }

	public boolean isActive() { return isActive; }

	public void setActive(boolean isActive) { this.isActive = isActive; }

	public LocalDate getLastApplyDate() { return lastApplyDate; }

	public void setLastApplyDate(LocalDate lastApplyDate) { this.lastApplyDate = lastApplyDate; }

	public LocalDate getCreateDate() { return createDate; }

	public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }

	public Employer getEmployer() { return employer; }

	public void setEmployer(Employer employer) { this.employer = employer; }

	public JobPosition getJobPosition() { return jobPosition; }

	public void setJobPosition(JobPosition jobPosition) { this.jobPosition = jobPosition; }

	public City getCity() { return city; }

	public void setCity(City city) { this.city = city; }
	
}
