package com.testyantra.empspringmvc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOFactory {

	@Bean("hibernate")
	public EmployeeDao getInstanceHibernate() {
		return new EmployeeDAOHibernateImpl();
	}// End of getInstance()
	@Bean("list")
	public EmployeeDao getInstanceList() {
		return new EmployeeDAOListImpl();
	}// End of getInstance()

}// End Of Class
