package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity




@Table(name="users")

public class User {

	
	@Id	
	@Column(name="user_id")
	
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id ;


	@Column(name="firstname", nullable=false)	
private String firstname;


	@Column(name="lastname", nullable=false)	
private String lastname;


	@Column(name="username", nullable=false)
private String username;

	
	@Column(name="password", nullable=false)
private String password;

	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="User_Type_FK")
	private UserType userTypeHolder;

	



@OneToMany(mappedBy="requestHolder", fetch=FetchType.LAZY)
	
private List<RepayRequest > repayRequestList = new ArrayList<RepayRequest>();







public List<RepayRequest> getRepayRequestList() {
	return repayRequestList;
}








public void setRepayRequestList(List<RepayRequest> repayRequestList) {
	this.repayRequestList = repayRequestList;
}





















public User() {
	super();
}





























//to get data from db user type holder is the foreign key to your user type table;
//you will get from db
//the list of repay request will be set later after you use the login user id to query from the repay request table;


public User(int id, String firstname, String lastname, String username, String password, UserType userTypeHolder) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.password = password;
	this.userTypeHolder = userTypeHolder;

}






//receive user for test


public User(String firstname, String lastname, String username, String password, UserType userTypeHolder) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.password = password;
	this.userTypeHolder = userTypeHolder;
}





//















public int getId() {
	return id;
}








public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public  UserType getUserrole() {
	return  userTypeHolder;
}
public void setUserrole( UserType  userTypeHolder) {
	this. userTypeHolder =  userTypeHolder;
}








@Override
public String toString() {
	return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
			+ ", password=" + password + ", userrole=" +  userTypeHolder.getUsertype() + ", repayRequestList=" + repayRequestList + "]";
}





















}
