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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="resume_work_experiences")
public class ResumeWorkExperiences {
	
	@Id
	@Column(name="id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="business_name" , nullable = false)
	@NotNull
	@NotBlank
	private String businessName ;
	
	@Column(name="position" , nullable = false)
	@NotNull
	@NotBlank
	private String position ;
	
	@Column(name="start_date" , nullable = false)
	@NotNull
	@NotBlank
	private LocalDate startDate ;
	
	@Column(name="finish_date" , nullable = true)
	private LocalDate finishDate ;
	
	@Column(name="still_working" , nullable = false)
	private boolean stillWorking ;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="resume_id")
	private Resume resume ;

	public ResumeWorkExperiences() {
		super();
	}
	
	public ResumeWorkExperiences(int id, @NotNull @NotBlank String businessName, @NotNull @NotBlank String position,
			@NotNull @NotBlank LocalDate startDate, LocalDate finishDate, boolean stillWorking) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.position = position;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.stillWorking = stillWorking;
	}
	
	public ResumeWorkExperiences(int id, @NotNull @NotBlank String businessName, @NotNull @NotBlank String position,
			@NotNull @NotBlank LocalDate startDate, LocalDate finishDate, boolean stillWorking, Resume resume) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.position = position;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.stillWorking = stillWorking;
		this.resume = resume;
	}

	
	public int getId() { return id; }
	

	public void setId(int id) { this.id = id; }


	public String getBusinessName() { return businessName; }

	
	public void setBusinessName(String businessName) { this.businessName = businessName; }

	
	public String getPosition() { return position; }

	
	public void setPosition(String position) { this.position = position; }

	
	public LocalDate getStartDate() { return startDate; }
	

	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

	
	public LocalDate getFinishDate() { return finishDate; }

	
	public void setFinishDate(LocalDate finishDate) { this.finishDate = finishDate; }

	
	public boolean isStillWorking() { return stillWorking; }
	

	public void setStillWorking(boolean stillWorking) { this.stillWorking = stillWorking; }
	

	public Resume getResume() { return resume; }
	

	public void setResume(Resume resume) { this.resume = resume; }
  
}
