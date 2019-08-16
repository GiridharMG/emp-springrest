package com.testyantra.empspringmvc.jaxb.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employee-response")
public class EmployeeResponse {

	@JsonProperty("status-code")
	private int statusCode;
	
	private String massage;

	private String decription;
	
	private List<EmployeeInfoBean> beans;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public List<EmployeeInfoBean> getBeans() {
		return beans;
	}

	public void setBeans(List<EmployeeInfoBean> beans) {
		this.beans = beans;
	}
	
}
