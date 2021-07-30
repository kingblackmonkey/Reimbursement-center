package service;

import dao.UserDao;
import model.User;

public class UserService {

	
	UserDao userDao = new UserDao();
	
	
	
	
	public User signin (String username, String password) {
		
		
		return  userDao.getAuserByUsernameAndPassword(username, password);
		
	}
}
