package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="varification_by_email")
public class VarificationByEmail {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	@Column(name="user_id" , nullable=false)
	private int userId ;
	

	@Column(name="activation_code_id" , nullable=false)
	private int codeId ;

	public VarificationByEmail() {}

	public VarificationByEmail(int userId, int codeId) {
		super();
		this.userId = userId;
		this.codeId = codeId;
	}

	public VarificationByEmail(int id, int userId, int codeId) {
		super();
		this.id = id;
		this.userId = userId;
		this.codeId = codeId;
	}
	
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public int getUserId() { return userId; }

	public void setUserId(int userId) { this.userId = userId; }

	public int getCodeId() { return codeId; }

	public void setCodeId(int codeId) { this.codeId = codeId; }
}
