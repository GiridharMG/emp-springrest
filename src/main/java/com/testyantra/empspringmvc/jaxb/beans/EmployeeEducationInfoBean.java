package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE_EDUCATIONAL_INFO")
public class EmployeeEducationInfoBean implements Serializable {

	@EmbeddedId
    protected EmployeeEducationPKBean educationPKBean;
	
	@JsonProperty("degree-type")
    @Column(name = "DEGREE_TYPE")
    protected String degreeType;
    
    @Column(name = "BRANCH")
    protected String branch;
    
    @JsonProperty("collage-name")
    @Column(name = "COLLEGE_NAME")
    protected String collageName;
    
    @Column(name = "UNIVERSITY")
    protected String university;
    
    @Column(name = "YOP")
    protected String yop;
    
    @Column(name = "PERCENTAGE")
    protected double percentage;
    
    @Column(name = "LOCATION")
    protected String location;

    public EmployeeEducationPKBean getEducationPKBean() {
        return educationPKBean;
    }

    public void setEducationPKBean(EmployeeEducationPKBean value) {
        this.educationPKBean = value;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String value) {
        this.degreeType = value;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String value) {
        this.branch = value;
    }

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String value) {
        this.collageName = value;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String value) {
        this.university = value;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String value) {
        this.yop = value;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double value) {
        this.percentage = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String value) {
        this.location = value;
    }

}
