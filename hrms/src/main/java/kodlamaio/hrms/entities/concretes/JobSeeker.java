package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class JobSeeker extends User{
	
	//@JsonIgnore
	@Column(name="first_name" , nullable = false)
	private String firstName ;
	
	@Column(name="last_name" , nullable = false)
	private String lastName ;
	
	@Column(name="identification_number" , nullable = false)
	private String identificationNumber ;
	
	@Column(name="year_of_birth" , nullable = false)
	private String yearOfBirth ;
	
	@OneToOne(mappedBy = "jobSeeker" , fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private Resume resume ;
	
	public JobSeeker() { super(); }

	public JobSeeker(String firstName, String lastName, String identificationNumber, String yearOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.identificationNumber = identificationNumber;
		this.yearOfBirth = yearOfBirth;
	}
	
	public JobSeeker(String firstName, String lastName, String identificationNumber, String yearOfBirth , Resume resume ) {
		super();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.identificationNumber = identificationNumber;
		this.yearOfBirth = yearOfBirth;
		this.resume = resume ;
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getIdentificationNumber() { return identificationNumber; }

	public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }

	public String getYearOfBirth() { return yearOfBirth; }

	public void setDateOfBirth(String yearOfBirth) { this.yearOfBirth = yearOfBirth; }
	
    public Resume getResume() { return resume; }
	
	public void setResume(Resume resume) { this.resume = resume; }
	
}
