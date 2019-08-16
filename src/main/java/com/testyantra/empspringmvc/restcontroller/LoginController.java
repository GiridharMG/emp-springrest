package com.testyantra.empspringmvc.restcontroller;

import static com.testyantra.empspringmvc.commons.EMPConstants.DB_INTERACTION_TYPE;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.empspringmvc.dao.EmployeeDao;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	private EmployeeDao dao;
	
	@PostMapping(value = "/auth", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse login(int id, String password,
				HttpServletRequest request) {
		
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		EmployeeResponse response = new EmployeeResponse();
		if(bean!=null && bean.getPassword().equals(password)) {
			response.setStatusCode(201);
			response.setMassage("Successfull");
			response.setDecription("Loged in successfully");
			response.setBeans(Arrays.asList(bean));
			request.getSession().setAttribute("bean", bean);
		}else {
			response.setStatusCode(401);
			response.setMassage("Failure");
			response.setDecription("Invalid credencials");
		}
		return response;
	}
	
	@GetMapping(value = "/logout",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse logout(HttpSession session) {
		session.invalidate();
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(201);
		response.setMassage("Successfull");
		response.setDecription("Loged out successfully");
		
		return response;
	}
	
	@GetMapping(value = "/readcookie",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse readCookie(
			@CookieValue(name = "JSESSIONID") String sessionId) {
		
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(201);
		response.setMassage("Successfull");
		response.setDecription("JSESSIONID : "+sessionId);
		
		return response;
	}
	
}















