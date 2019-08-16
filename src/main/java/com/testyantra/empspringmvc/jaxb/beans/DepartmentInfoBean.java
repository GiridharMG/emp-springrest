package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENT_INFO")
public class DepartmentInfoBean implements Serializable {

	@JsonProperty("department-id")
    @Id
	@Column(name = "DEPT_ID")
    protected int departmentId;
    
	@JsonProperty("department-name")
    @Column(name = "DEPT_NAME")
    protected String departmentName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int value) {
        this.departmentId = value;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String value) {
        this.departmentName = value;
    }

}
