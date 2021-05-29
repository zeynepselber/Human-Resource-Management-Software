package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activation_codes" )
public class ActivationCode {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)  
	@Column(name="id")
	private int id ;
	
	@Column(name="code" , nullable=false , unique=true)
	private String code ;
	
	@Column(name="is_activated" , nullable=false)
	private boolean isActivated ;
	
	public ActivationCode() {}
	
	public ActivationCode(String code, boolean isActivated) {
		super();
		this.code = code;
		this.isActivated = isActivated;
	}
	
	public ActivationCode(int id, String code, boolean isActivated) {
		super();
		this.id = id;
		this.code = code;
		this.isActivated = isActivated;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }
	
	public String getCode() { return code; }

	public void setCode(String code) { this.code = code; }

	public boolean isActivated() { return isActivated; }
	
	public void setActivated(boolean isActivated) { this.isActivated = isActivated; }
		
}
