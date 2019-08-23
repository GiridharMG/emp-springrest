package com.testyantra.empspringmvc.apptest;

import com.testyantra.empspringmvc.dao.EmployeeDAOHibernateImpl;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeAddressInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeAddressPKBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeOtherInfoBean;

public class App {
	
	public static void main(String[] args) {
		EmployeeInfoBean bean1 = new EmployeeInfoBean();
		bean1.setId(6);
		bean1.setName("Giridhar");
		bean1.setDesignation("SD");

		EmployeeOtherInfoBean otherInfoBean = new EmployeeOtherInfoBean();
		otherInfoBean.setAadhar(1234567890);
		otherInfoBean.setPan("PAN1234567890");
		otherInfoBean.setId(bean1);
		bean1.setOtherInfo(otherInfoBean);
		
		EmployeeAddressPKBean addressPKBean1 = new EmployeeAddressPKBean();
		addressPKBean1.setAddressType("T");
		addressPKBean1.setId(bean1);
		EmployeeAddressPKBean addressPKBean2 = new EmployeeAddressPKBean();
		addressPKBean2.setAddressType("P");
		addressPKBean2.setId(bean1);
		
		EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
		addressInfoBean1.setAddressPKBean(addressPKBean1);
		addressInfoBean1.setAddress1("abc");
		addressInfoBean1.setAddress2("def");
		EmployeeAddressInfoBean addressInfoBean2 = new EmployeeAddressInfoBean();
		addressInfoBean2.setAddressPKBean(addressPKBean2);
		addressInfoBean2.setAddress1("pqr");
		addressInfoBean2.setAddress2("xyz");
		
		//bean1.setAddressInfoBeans(Arrays.asList(addressInfoBean1,addressInfoBean2));
		
		
		EmployeeDAOHibernateImpl impl = new EmployeeDAOHibernateImpl();
		impl.createEmployeeInfo(bean1);
	}
	// end of main
}// end of App




















