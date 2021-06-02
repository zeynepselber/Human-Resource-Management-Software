package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume_work_experiences" ,"resume_languages" , "resume_programming_languages" , "resume_schols"})
public class Resume {

	@Id
	@Column(name="id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="image" , nullable = true)
	private String image ;
	
	@Column(name="github_address" , nullable = true)
	private String githubAddress;
	
	@Column(name="linkedin_address" , nullable = true)
	private String linkedinAddress;
	
	@Column(name="cover_letter" , nullable = true)
	private String coverLetter ;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker ;
	
	@OneToMany(mappedBy = "resume" , fetch = FetchType.LAZY) 
	private List<ResumeWorkExperiences> resumeWorkExperiences ;
	
	@OneToMany(mappedBy = "resume" , fetch = FetchType.LAZY) 
	private List<ResumeLanguages> resumeLanguages ;
	
	@OneToMany(mappedBy = "resume" , fetch = FetchType.LAZY) 
	private List<ResumeProgrammingLanguages> resumeProgrammingLanguages ;
	
	@OneToMany(mappedBy = "resume" , fetch = FetchType.LAZY) 
	private List<ResumeSchools> resumeSchools ;

	public Resume() { super(); }
	
	public Resume(int id, String image, String githubAddress, String linkedinAddress, String coverLetter) {
		super();
		this.id              = id;
		this.image           = image;
		this.githubAddress   = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.coverLetter     = coverLetter;
	}
	
	public Resume(int id, String image, String githubAddress, String linkedinAddress, String coverLetter, 
			      JobSeeker jobSeeker, List<ResumeWorkExperiences> resumeWorkExperiences,
			      List<ResumeLanguages> resumeLanguages, List<ResumeProgrammingLanguages> resumeProgrammingLanguages, List<ResumeSchools> resumeSchools  ) {
		super();
		this.id              = id;
		this.image           = image;
		this.githubAddress   = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.coverLetter     = coverLetter;
		this.jobSeeker       = jobSeeker;
		this.resumeWorkExperiences = resumeWorkExperiences ;
		this.resumeLanguages = resumeLanguages ;
		this.resumeProgrammingLanguages= resumeProgrammingLanguages ;
		this.resumeSchools = resumeSchools ;
	}

	
	public int getId() { return id; }
	

	public void setId(int id) { this.id = id; }
	

	public String getImage() { return image; }
	

	public void setImage(String image) { this.image = image; }
	

	public String getGithubAddress() { return githubAddress; }
	

	public void setGithubAddress(String githubAddress) { this.githubAddress = githubAddress; }
	

	public String getLinkedinAddress() { return linkedinAddress; }
	

	public void setLinkedinAddress(String linkedinAddress) { this.linkedinAddress = linkedinAddress; }
	

	public String getCoverLetter() { return coverLetter; }
	

	public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }
	

	public JobSeeker getJobSeeker() { return jobSeeker; }
	

	public void setJobSeeker(JobSeeker jobSeeker) { this.jobSeeker = jobSeeker; }
	
	public List<ResumeWorkExperiences> getResumeWorkExperiences() { return resumeWorkExperiences; }

	public void setResumeWorkExperiences(List<ResumeWorkExperiences> resumeWorkExperiences) { this.resumeWorkExperiences = resumeWorkExperiences; }
	
	public List<ResumeLanguages> getResumeLanguages() { return resumeLanguages; }

	public void setResumeLanguages( List<ResumeLanguages> resumeLanguages) { this.resumeLanguages = resumeLanguages; }
	
	public List<ResumeProgrammingLanguages> getResumeProgrammingLanguages() { return resumeProgrammingLanguages; }

	public void setResumeProgrammingLanguages( List<ResumeProgrammingLanguages> resumeProgrammingLanguages) { this.resumeProgrammingLanguages = resumeProgrammingLanguages; }
	
	public List<ResumeSchools> getResumeSchools() { return resumeSchools; }

	public void setResumeSchools( List<ResumeSchools> resumeSchools) { this.resumeSchools = resumeSchools; }
	
}
