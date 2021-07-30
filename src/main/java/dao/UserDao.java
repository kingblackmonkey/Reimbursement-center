package dao;



import org.hibernate.Session;
import org.hibernate.Transaction;



import model.User;
import util.HibernateUtil;

public class UserDao {

	
	
	//get a user  username pass word
	
	public User getAuserByUsernameAndPassword (String username, String password) {
		
		

		User user = new User();
		
return user;
//		try {
//			Connection con = conUtil.getConnection();
//			String sql = "SELECT * FROM users WHERE users.username = '" + name +"'";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//
//			while(rs.next()) {
//				user.setId(rs.getInt(1));
//				user.setFirstName(rs.getString(2));
//				user.setLastName(rs.getString(3));
//				user.setEmail(rs.getString(4));
//				user.setUsername(rs.getString(5));
//				user.setPassword(rs.getString(6));
//			}
//
//			return user;
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		
	}
	
	//get user account   id
	
	
	//update account  id 
	
	
	
	public void insert(User user) {
		//First we need to open up a session
		Session ses = HibernateUtil.getSession();
		//Then we must start a transaction
		org.hibernate.Transaction tx = ses.beginTransaction();
		//Use the session method .save() to write the super villain object to our database
		ses.save(user);
		//Commit the transaction
		tx.commit();
		//Close the session once you are done
		//ses.close();
	}
	
	
	
	public User selectUser(int id) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		 User user = ses.get( User.class, id);
		//ses.close();
		return user;
	}
	
	
	//update should use same number of fields 
	public void update(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(user);
		tx.commit();
	}
	
	
}
