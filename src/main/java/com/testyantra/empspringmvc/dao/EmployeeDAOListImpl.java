package com.testyantra.empspringmvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.testyantra.empspringmvc.jaxb.beans.EmployeeEducationInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeEducationPKBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeExperinceInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeExperincePKBean;
import com.testyantra.empspringmvc.jaxb.beans.DepartmentInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeAddressInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeAddressPKBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeOtherInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.TrainingInfoBean;

public class EmployeeDAOListImpl implements EmployeeDao {

	private static List<EmployeeInfoBean> beans= new ArrayList<EmployeeInfoBean>();  
	
	
	
	
	{
		EmployeeInfoBean infoBean = new EmployeeInfoBean();
		infoBean.setId(1);
		infoBean.setName("Praveen");
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(2);
		bean.setName("Giridhar");
		bean.setDesignation("SD");
		bean.setAge(26);
		bean.setGender("Male");
		bean.setSalary(100000);
		bean.setPhoneNum(9876543210L);
		bean.setEmailId("giridhar.mg@testyantra.in");
		bean.setManagerId(infoBean);
		try {
			bean.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1993-08-09"));
			bean.setJoiningDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-01"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setAccountNumber(123456789012L);
		bean.setPassword("qwerty");
		
		EmployeeOtherInfoBean otherInfoBean = new EmployeeOtherInfoBean();
		otherInfoBean.setAadhar(1234567890);
		otherInfoBean.setPan("PAN1234567890");
		otherInfoBean.setId(bean);
		otherInfoBean.setMarried(false);
		otherInfoBean.setBloodGroup("B+ve");
		otherInfoBean.setChalenged(false);
		otherInfoBean.setEmergencyNumber(9876543210L);
		otherInfoBean.setEmergencyContactName("Praveen");
		otherInfoBean.setNationality("Indian");
		otherInfoBean.setReligion("Hindhu");
		otherInfoBean.setFatherName("Gopala");
		otherInfoBean.setMotherName("Rani");
		
		bean.setOtherInfo(otherInfoBean);
		
		EmployeeAddressPKBean addressPKBean1 = new EmployeeAddressPKBean();
		addressPKBean1.setAddressType("T");
		addressPKBean1.setId(bean);
		EmployeeAddressPKBean addressPKBean2 = new EmployeeAddressPKBean();
		addressPKBean2.setAddressType("P");
		addressPKBean2.setId(bean);
		
		EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
		addressInfoBean1.setAddressPKBean(addressPKBean1);
		addressInfoBean1.setAddress1("Kengeri");
		addressInfoBean1.setAddress2("Kengeri");
		addressInfoBean1.setLandmark("Mori");
		addressInfoBean1.setCity("Bangalore");
		addressInfoBean1.setState("Karnataka");
		addressInfoBean1.setCountry("India");
		addressInfoBean1.setPincode(560060);
		
		EmployeeAddressInfoBean addressInfoBean2 = new EmployeeAddressInfoBean();
		addressInfoBean2.setAddressPKBean(addressPKBean2);
		addressInfoBean2.setAddress1("Mattur");
		addressInfoBean2.setAddress2("Shimoga");
		addressInfoBean2.setLandmark("Tunga River");
		addressInfoBean2.setCity("Shimoga");
		addressInfoBean2.setState("Karnataka");
		addressInfoBean2.setCountry("India");
		addressInfoBean2.setPincode(577203);
		
		bean.setAddessInfo(Arrays.asList(addressInfoBean1, addressInfoBean2));
		
		EmployeeEducationPKBean educationPKBean = new EmployeeEducationPKBean();
		educationPKBean.setId(bean);
		educationPKBean.setEducationType("FullTime");
		
		EmployeeEducationInfoBean educationInfoBean = new EmployeeEducationInfoBean();
		educationInfoBean.setEducationPKBean(educationPKBean);
		educationInfoBean.setBranch("CS");
		educationInfoBean.setDegreeType("BE");
		educationInfoBean.setCollageName("PESIT");
		educationInfoBean.setLocation("Shimoga");
		educationInfoBean.setUniversity("VTU");
		educationInfoBean.setYop("2015");
		educationInfoBean.setPercentage(99);
		
		bean.setEducationInfo(Arrays.asList(educationInfoBean));
		
		EmployeeExperincePKBean experincePKBean = new EmployeeExperincePKBean();
		experincePKBean.setCompanyName("JSpiders");
		experincePKBean.setId(bean);
		
		EmployeeExperinceInfoBean experinceInfoBean = new EmployeeExperinceInfoBean();
		experinceInfoBean.setExperincePKBean(experincePKBean);
		experinceInfoBean.setDesignation("SD");
		try {
			experinceInfoBean.setJoiningDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-08-01"));
			experinceInfoBean.setLeavingDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		bean.setExperinceInfo(Arrays.asList(experinceInfoBean));
		
		DepartmentInfoBean departmentInfoBean = new DepartmentInfoBean();
		departmentInfoBean.setDepartmentId(101);
		departmentInfoBean.setDepartmentName("Development");
		
		bean.setDepartmentInfo(departmentInfoBean);
		
		TrainingInfoBean trainingInfoBean1 = new TrainingInfoBean();
		trainingInfoBean1.setCourseId(11);
		trainingInfoBean1.setCourseName("JAVA");
		trainingInfoBean1.setCourseType("FullTime");
		trainingInfoBean1.setDuration(3);
		
		TrainingInfoBean trainingInfoBean2 = new TrainingInfoBean();
		trainingInfoBean2.setCourseId(12);
		trainingInfoBean2.setCourseName("J2EE");
		trainingInfoBean2.setCourseType("FullTime");
		trainingInfoBean2.setDuration(3);
		
		bean.setTrainingInfo(Arrays.asList(trainingInfoBean1, trainingInfoBean2));
		
		createEmployeeInfo(bean); 
	}
	@Override
	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		return beans;
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(int id) {
		for(EmployeeInfoBean bean : beans) {
			if(bean.getId() == id) {
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		bean.getOtherInfo().setId(bean);
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfo()) {
			addressInfoBean.getAddressPKBean().setId(bean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : bean.getEducationInfo()) {
			educationInfoBean.getEducationPKBean().setId(bean);
		}
		for (EmployeeExperinceInfoBean experinceInfoBean : bean.getExperinceInfo()) {
			experinceInfoBean.getExperincePKBean().setId(bean);
		}
		return beans.add(bean);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		EmployeeInfoBean removeBean = null;
		for(EmployeeInfoBean infoBean : beans) {
			if(infoBean.equals(bean)){
				removeBean = infoBean;
			}
		}
		if(removeBean!=null) {
			beans.remove(removeBean);
			return beans.add(bean);
		}
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		for(EmployeeInfoBean infoBean : beans) {
			if(infoBean.getId()==id){
				return beans.remove(infoBean);
			}
		}
		return false;
	}
}
