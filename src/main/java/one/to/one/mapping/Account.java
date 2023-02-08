package one.to.one.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "account")
public class Account {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int ac_id;
	@Column(name = "type")
	private String ac_type;
	
//	bidirectional mapping where we provided annotation to the reference variable of employee class which will be an foreign key in Account table
	@OneToOne (targetEntity = Employee.class)
	private Employee emp;
	
//	we need getters and setters to perform the operation
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public String getAc_type() {
		return ac_type;
	}
	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}
	@Override
	public String toString() {
		return "Account [ac_id=" + ac_id + ", ac_type=" + ac_type + ", emp=" + emp + "]";
	}
	
}
