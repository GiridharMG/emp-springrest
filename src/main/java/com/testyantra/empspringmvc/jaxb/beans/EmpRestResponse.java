package com.testyantra.empspringmvc.jaxb.beans;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employee-response")
public class EmpRestResponse {

	protected int statusCode;

	protected String message;
    
	protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int value) {
        this.statusCode = value;
    }

}
