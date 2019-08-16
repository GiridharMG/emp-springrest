package com.testyantra.empspringmvc.dao;

import java.util.List;

import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;

//import com.testyantra.empspringmvc.beans.EmployeeInfoBean;


public interface EmployeeDao {

	List<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(int id);

	boolean createEmployeeInfo(EmployeeInfoBean bean);

	boolean updateEmployeeInfo(EmployeeInfoBean bean);

	boolean deleteEmployeeInfo(int id);
}
