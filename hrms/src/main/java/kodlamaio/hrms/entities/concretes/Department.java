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
@Table(name="departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "resume_schols"})
public class Department {

	@Id
	@Column(name="id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="name" , nullable = false)
	@NotBlank
	@NotNull
	private String name;

	@OneToMany(mappedBy = "department" , fetch = FetchType.LAZY) 
	private List<ResumeSchools> resumeSchools ;
	
	public Department() {
		super();
	}
	
	public Department(int id, @NotBlank @NotNull String name , List<ResumeSchools> resumeSchools) {
		super();
		this.id = id;
		this.name = name;
		this.resumeSchools = resumeSchools;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
	
	public List<ResumeSchools> getResumeSchools() { return resumeSchools; }

	public void setResumeSchools(List<ResumeSchools> resumeSchools) { this.resumeSchools = resumeSchools; }
}
