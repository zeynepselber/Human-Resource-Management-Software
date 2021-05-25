package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_positions")
public class JobPosition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id ;
	
	@Column(name="position_name" , nullable = false)
	private String positionName ;
	
	public JobPosition() {}

	public JobPosition(String positionName) {
		this.positionName = positionName;
	}
	
	public JobPosition(int id, String positionName) {
		this.id = id;
		this.positionName = positionName;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getPositionName() { return positionName; }

	public void setPositionName(String positionName) { this.positionName = positionName; }
 
}
