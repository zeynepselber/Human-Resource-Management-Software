package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="system_personal")
public class SystemPersonal extends User{
	
	@Column(name="first_name" , nullable=false)
	private String firstName ;
	
	@Column(name="last_name" , nullable=false)
	private String lastName ;
	
	public SystemPersonal() { super(); }
	
	public SystemPersonal( String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName  = lastName;
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }

	public void setLastName(String lastName) {this.lastName = lastName; }
	
}
