package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE_EXPERINCEINFO")
public class EmployeeExperinceInfoBean implements Serializable {

	@EmbeddedId
    protected EmployeeExperincePKBean experincePKBean;
	
	@Column(name = "DESIGNATION")
    protected String designation;
	
	@JsonProperty("joining-date")
    @Column(name = "JOINING_DATE")
    protected Date joiningDate;
    
	@JsonProperty("leaving-date")
    @Column(name = "LEAVING_DATE")
    protected Date leavingDate;

    public EmployeeExperincePKBean getExperincePKBean() {
        return experincePKBean;
    }

    public void setExperincePKBean(EmployeeExperincePKBean value) {
        this.experincePKBean = value;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String value) {
        this.designation = value;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date value) {
        this.joiningDate = value;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date value) {
        this.leavingDate = value;
    }

}
