package dao;

import java.util.List;

import org.hibernate.Session;

import model.RepayRequest;
import model.User;
import util.HibernateUtil;

public class RepayRequestDao {

	
//	in repay request object must  have the user object which is request holder and has the id in it so hibernate know where to link to user
	//to insert new request in repay request table ; for employee
	public void insert(RepayRequest repayRequest) {
		//First we need to open up a session
		Session ses = HibernateUtil.getSession();
		//Then we must start a transaction
		org.hibernate.Transaction tx = ses.beginTransaction();
		//Use the session method .save() to write the super villain object to our database
		ses.save(repayRequest);
		//Commit the transaction
		tx.commit();
		//Close the session once you are done
		//ses.close();
	}
	
	
	
	
	
	//get all repay requests by id for employee with condition pending; for employee; must use the class name instead of table name;
	public  List <RepayRequest>  getAllPendingRepayRequestForAnEmployee(int id) {
		
		
		//HQL Hibernate Query Language creates complex queries using a combo of OOP and SQL
				Session ses = HibernateUtil.getSession();
				List<RepayRequest> pendingRequestsList = ses.createQuery("from RepayRequest where user_fk='" + id + "'" + "and status="+ "'" +"pending'", RepayRequest.class).list();
				if(pendingRequestsList.size() == 0) {
					return null;
				}
				return pendingRequestsList;
		
		
		
		
	}
	
	//get all request for specific employee with condition approved and denied; take id ;for employee
	
	

	
	
	//
	//get all repay request based on pending status;  take in id ;for employee
	
	
	
	//update repay request status using id of employee ; this is for manager
	
	//get all request from all employee with condition pending status for manager 
	
	
	//get all repay  request of an employee ; take in id of employee; for manager 
	
	//get all repay request by id; this should take employee id; will return all requests with pending; approved and denied
	
	
	
	
}
