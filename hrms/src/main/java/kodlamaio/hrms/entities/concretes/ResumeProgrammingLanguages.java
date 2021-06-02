package kodlamaio.hrms.entities.concretes;

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
@Table(name="resume_programming_languages")
public class ResumeProgrammingLanguages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "resume_id")
	private Resume resume ;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "programming_language_id")
	private ProgrammingLanguage programmingLanguage ;

	public ResumeProgrammingLanguages() {
		super();
	}
	
	public ResumeProgrammingLanguages(int id, Resume resume, ProgrammingLanguage programmingLanguage) {
		super();
		this.id = id;
		this.resume = resume;
		this.programmingLanguage = programmingLanguage;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public Resume getResume() { return resume; }

	public void setResume(Resume resume) { this.resume = resume; }

	public ProgrammingLanguage getProgrammingLanguage() { return programmingLanguage; }

	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) { this.programmingLanguage = programmingLanguage; }
	
}
