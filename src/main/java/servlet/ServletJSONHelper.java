package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import   controllers.LoginJsonController;

public class ServletJSONHelper {

	
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/RepayHub/api/login":
				 LoginJsonController.login(req, res);
				break;
//			case "/SocialHubWeek3/api/logout":
//				LogoutController.logout(req, res);
//				break;
//			case "/SocialHubWeek3/api/posts":
//				PostsController.handlePosts(req, res);
//				break;
//			case "/SocialHubWeek3/api/session":
//				SessionController.getSession(req, res);
//				break;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
