package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	@Column(name="email" , nullable=false , unique=true)
	private String email ;
	
	@Column(name="password" , nullable=false)
	private String password ;
	
	@Column(name="password_repeat" , nullable=false)
	private String passwordRepeat ;
	
	public User() {}

	public User(int id, String email, String password , String passwordRepeat) {
		this.id       = id;
		this.email    = email;
		this.password = password;
		this.passwordRepeat = passwordRepeat ;
	}
	
	public User( String email, String password , String passwordRepeat) {
		this.email    = email;
		this.password = password;
		this.passwordRepeat = passwordRepeat ;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email;	}

	public String getPassword() { return password;}

	public void setPassword(String password) { this.password = password; }
	
	public String getPasswordRepeat() { return passwordRepeat;}

	public void setPasswordRepeat(String passwordRepeat) { this.passwordRepeat = passwordRepeat; }

}
