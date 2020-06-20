package com.escobar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("In the login method");
		
		return "login"; // By returning login, this tells the internal resource view resolver inside of WEB-INF/config/servlet-config.xml
						// that we want to look into /WEB-INF/jsp/ (i.e. p:prefix="/WEB-INF/jsp/") for whatever string we return 
						// with a suffix of jsp (i.e. p:suffix=".jsp"). So, this will look for login.jsp in the WEB-INF/jsp directory. 
	}
	
	// One of the reasons I like using a login controller rather than just passing directly to Jsp pages is I could come in here and 
	// add extra information. Maybe I logged the number of failed attempts that somebody has with user name or password. We can do some 
	// intrusion detection. We could do a lot of valuable things by having this outside of just JSP pages and wired into a proper controller like this.
	// You also get better logging and kind of see what's going on inside of your application. So this is a much more robust way of doing things and
	// the way I prefer to do it inside of my apps.
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		System.out.println("In the loginFailed method");
		model.addAttribute("error", "true");
		return "login"; // Returns the login page, because I put that <c:if> block in login.jsp. The <c:if> block is what will be executed. 
						// In the <c:if> block, test attribute (i.e. test="${not empty error}) is looking for the error attribute in the response. Then it
						// will display the information in the <div>.
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model) {
		System.out.println("In the logout method");
		
		return "logout";
	}

	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String error403(ModelMap model) {
		System.out.println("In the logout method");
		return "403";
		// There's other ways to handle this. We can direct it to a controller, like we are, and navigate it differently or do different things, 
		// like navigate them to the portion of the application they do have permissions to. But now we have a standard 403 page that's 
		// tied into our application. We're not showing that ugly Tomcat error when somebody doesn't have the correct permissions.
	}
}
