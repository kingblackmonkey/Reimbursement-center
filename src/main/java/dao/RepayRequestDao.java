package dao;

import org.hibernate.Session;

import model.RepayRequest;
import model.User;
import util.HibernateUtil;

public class RepayRequestDao {

	
//	in repay request object must  have the user object which is request holder and has the id in it so hibernate know where to link to user
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
	
	
	
	
	
	
}
