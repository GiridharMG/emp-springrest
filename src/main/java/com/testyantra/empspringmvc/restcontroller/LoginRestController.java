package com.testyantra.empspringmvc.restcontroller;

import static com.testyantra.empspringmvc.commons.EMPConstants.DB_INTERACTION_TYPE;
import static com.testyantra.empspringmvc.commons.EMPConstants.PROPERTY_FILE;
import static com.testyantra.empspringmvc.commons.EMPConstants.VIEW_HOME_PAGE;
import static com.testyantra.empspringmvc.commons.EMPConstants.VIEW_LOGIN_PAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testyantra.empspringmvc.dao.EmployeeDao;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;

@Controller
@RequestMapping("/loginrest")
@PropertySource(PROPERTY_FILE)
public class LoginRestController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	EmployeeDao dao;

	@GetMapping("/loginPage")
	public String loginPage() {
		return VIEW_LOGIN_PAGE;
	}

	@PostMapping("/authenticate")
	public String authenticate(int id, String password, HttpServletRequest req,
			@Value("${invalidCredentials}") String errMsg) {

		EmployeeInfoBean employeeInfoBean = dao.getEmployeeInfo(id);

		if (employeeInfoBean == null || !employeeInfoBean.getPassword().equals(password)) {
			req.setAttribute("msg", errMsg);
			return VIEW_LOGIN_PAGE;
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("bean", employeeInfoBean);
			return VIEW_HOME_PAGE;
		} // End of if-else
	}// End of authenticate

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map, @Value("${logoutMsg}") String msg) {
		session.invalidate();
		map.addAttribute("msg", msg);
		return VIEW_LOGIN_PAGE;
	}// End of logout

}// End of Class
