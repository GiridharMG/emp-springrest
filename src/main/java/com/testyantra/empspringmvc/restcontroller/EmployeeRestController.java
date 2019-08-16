package com.testyantra.empspringmvc.restcontroller;

import static com.testyantra.empspringmvc.commons.EMPConstants.DB_INTERACTION_TYPE;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.empspringmvc.dao.EmployeeDao;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeResponse;

@RestController
@RequestMapping("/employeerest")
public class EmployeeRestController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	private EmployeeDao dao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}// End of initBinder()

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(int id, HttpServletRequest request) {

		EmployeeResponse response = new EmployeeResponse();
		if (request.getSession(false) != null) {
			EmployeeInfoBean bean = dao.getEmployeeInfo(id);
			if (bean != null) {
				response.setStatusCode(201);
				response.setMassage("Successfull");
				response.setDecription("Employee data found successfully");
				response.setBeans(Arrays.asList(bean));
			} else {
				response.setStatusCode(401);
				response.setMassage("Failure");
				response.setDecription("Employee data not found");
			}
			return response;
		} else {
			response.setStatusCode(501);
			response.setMassage("Failure");
			response.setDecription("Please login first");
			return response;
		}
	}// End of getEmployee()

	@GetMapping(path = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee() {

		List<EmployeeInfoBean> beans = dao.getAllEmployeeInfo();
		EmployeeResponse response = new EmployeeResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMassage("Successfull");
			response.setDecription("Employee data found successfully");
			response.setBeans(beans);
		} else {
			response.setStatusCode(401);
			response.setMassage("Failure");
			response.setDecription("Employee data not found");
		}
		return response;

		// return dao.getAllEmployeeInfo();
	}// End of getAllEmployee()

	@PostMapping(path = "/createEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean bean) {

		EmployeeResponse response = new EmployeeResponse();
		if (dao.createEmployeeInfo(bean)) {
			response.setStatusCode(201);
			response.setMassage("Successfull");
			response.setDecription("Employee data inserted successfully");
		} else {
			response.setStatusCode(401);
			response.setMassage("Failure");
			response.setDecription("Employee data not inserted successfully");
		}

		return response;
	}// End of creatEmployee()

	@PutMapping(path = "/updateEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (dao.updateEmployeeInfo(bean)) {
			response.setStatusCode(201);
			response.setMassage("Successfull");
			response.setDecription("Employee data updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMassage("Failure");
			response.setDecription("Employee data not updated successfully");
		}

		return response;
	}// End of updateEmployee()

	@DeleteMapping(path = "/removeEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse removeEmployee(@RequestParam("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (dao.deleteEmployeeInfo(id)) {
			response.setStatusCode(201);
			response.setMassage("Successfull");
			response.setDecription("Employee data deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMassage("Failure");
			response.setDecription("Employee data not deleted successfully");
		}
		return response;
	}// End of removeEmployee()

}// End of controller
