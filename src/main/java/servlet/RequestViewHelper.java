package servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import controllers.LoginViewController;

public class RequestViewHelper {

	
	
	
	//This is the class the will delegate tasks to certain controllers
	public static String process(HttpServletRequest req) throws ServletException, IOException {
		System.out.println("In the request helper, with the URI: " + req.getRequestURI());
		//We will use the specific URI's to send the request to the correct controller
		switch(req.getRequestURI()) {
			case "/RepayHub/login":
				return LoginViewController.fetchLoginPage(req);
		}
		return "/RepayHub/login";
	}
	
	
	
}
