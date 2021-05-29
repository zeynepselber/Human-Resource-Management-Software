package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
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
	
	public JobSeeker() { super(); }

	public JobSeeker(String firstName, String lastName, String identificationNumber, String yearOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.identificationNumber = identificationNumber;
		this.yearOfBirth = yearOfBirth;
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getIdentificationNumber() { return identificationNumber; }

	public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }

	public String getYearOfBirth() { return yearOfBirth; }

	public void setDateOfBirth(String yearOfBirth) { this.yearOfBirth = yearOfBirth; }
	
}
