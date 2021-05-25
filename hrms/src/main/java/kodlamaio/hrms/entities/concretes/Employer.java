package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Employer extends User{

	@Column(name="company_name" , nullable = false)
	private String companyName ;
	
	@Column(name="phone" , nullable = false)
	private String phone ;

	@Column(name="website" , nullable = false)
	private String website ;
	
	public Employer() { super(); }

	public Employer( String companyName, String phone, String website) {
		super();
		this.companyName = companyName;
		this.phone   = phone;
		this.website = website;
	}

	public String getCompanyName() { return companyName; }

	public void setCompanyName(String companyName) { this.companyName = companyName; }

	public String getPhone() { return phone; }

	public void setPhone(String phone) { this.phone = phone; }

	public String getWebsite() {return website; }

	public void setWebsite(String website) { this.website = website; }
	
}
