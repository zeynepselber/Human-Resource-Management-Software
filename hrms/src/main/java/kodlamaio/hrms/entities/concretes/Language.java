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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume_languages"})
public class Language {

	@Id
	@Column(name="id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="name" , nullable = false)
	@NotBlank
	@NotNull
	private String name;

	@OneToMany(mappedBy = "language" , fetch = FetchType.LAZY) 
	private List<ResumeLanguages> resumeLanguages ;
	
	public Language() {
		super();
	}
	
	public Language(int id, @NotBlank @NotNull String name , List<ResumeLanguages> resumeLanguages) {
		super();
		this.id = id;
		this.name = name;
		this.resumeLanguages = resumeLanguages;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
	
	public List<ResumeLanguages> getResumeLanguages() { return resumeLanguages; }

	public void setResumeLanguages(List<ResumeLanguages> resumeLanguages) { this.resumeLanguages = resumeLanguages; }
	
}
