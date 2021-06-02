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
@Table(name="resume_languages")
public class ResumeLanguages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "resume_id")
	private Resume resume ;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "language_id")
	private Language language ;

	@Column(name="level" , nullable = false)
	private int level ;
	
	public ResumeLanguages() {
		super();
	}
	
	public ResumeLanguages(int id, Resume resume, Language language, int level) {
		super();
		this.id = id;
		this.resume = resume;
		this.language = language;
		this.level = level ;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public Resume getResume() { return resume; }

	public void setResume(Resume resume) { this.resume = resume; }

	public Language getLanguage() { return language; }

	public void setLanguage(Language language) { this.language = language; }
	
	public int getLevel() { return level; }

	public void setLevel(int level) { this.level = level; }
	
}
