package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;

import model.User;
import service.UserService;

public class LoginJsonController {

	
	
//	private static UserDao uDao = new UserDaoConcrete();
//	private static UserService uServ = new UserService(uDao);

	public static void login(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{

	
	
		
		
		//To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();

		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
	
		ObjectMapper mapper = new ObjectMapper();
		
		
		//-----------------------------------------------------------------------------------------
		//this is to turn json array of object to  java array list and send back request; field of object user or request from client must be the same in user or request
//		List <User> users = mapper.readValue(data, new TypeReference<List<User>>(){});
//		
//		System.out.println(users);
//		res.setStatus(HttpServletResponse.SC_OK);
//		res.getWriter().write(new ObjectMapper().writeValueAsString(users));

		
		//----------------------------------
		
		//parsing single object
		
		JsonNode parsedObj = mapper.readTree(data);

		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();

		try {
			System.out.println("In login json handler   " +  username + "    "   + password );
		
//			User u = uServ.signIn(username, password);
			//System.out.println(u);
			
			//We will keep track of if the user is logged in by storing their id in the session		
			
			
             //		req.getSession().setAttribute("name", user.getName());
		
	

			UserService userSer = new UserService(); 
		 User user = 	userSer.signin(username, password);

			res.setStatus(HttpServletResponse.SC_OK);
			res.getWriter().write(new ObjectMapper().writeValueAsString(user));

			
		
			

			

		
			
		}
		catch(Exception e) {
		res.setStatus(HttpServletResponse.SC_FORBIDDEN);
		res.getWriter().println(" hello incorrect me lets gooo");
		
	
		}
		

		

		

		
	}
	
	
	
	
	
}
