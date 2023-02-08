package one.to.one.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "emp")
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "f_name")
	private String first_name;
	@Column (name = "l_name")
	private String last_name;
	
//	one to one mapping - one employee has one account
//	target entity - the table(class) which we are joining the column as foreign key with its primary key 
//	cascade - the operations(save, delete,update) we will perform on employee will be reflected on account
	@OneToOne (targetEntity = Account.class, cascade = CascadeType.ALL)
	private Account ac;
	
	public Account getAc() {
		return ac;
	}
	public void setAc(Account ac) {
		this.ac = ac;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
