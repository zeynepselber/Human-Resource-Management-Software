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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="resume_schools")
public class ResumeSchools {

	@Id
	@Column(name="id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="start_date" , nullable = false)
	private LocalDate startDate ;
	
	@Column(name="finish_date" , nullable = true)
	private LocalDate finishDate;
	
	@Column(name="is_graduate" , nullable = false )
	private boolean isGraduate ;
	
    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="resume_id")
	private Resume resume ;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="school_id")
	private School school ;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="department_id")
	private Department department ;

    public ResumeSchools() {
		super();
	}
    
	public ResumeSchools(int id, LocalDate startDate, LocalDate finishDate, boolean isGraduate, Resume resume,
			School school, Department department) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.isGraduate = isGraduate;
		this.resume = resume;
		this.school = school;
		this.department = department;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public LocalDate getStartDate() { return startDate; }

	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

	public LocalDate getFinishDate() { return finishDate; }

	public void setFinishDate(LocalDate finishDate) { this.finishDate = finishDate; }

	public boolean isGraduate() { return isGraduate; }

	public void setGraduate(boolean isGraduate) { this.isGraduate = isGraduate; }

	public Resume getResume() { return resume; }

	public void setResume(Resume resume) { this.resume = resume; }

	public School getSchool() { return school; }

	public void setSchool(School school) { this.school = school; }

	public Department getDepartment() { return department; }

	public void setDepartment(Department department) { this.department = department; }
    
}
