package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Embeddable
public class EmployeeEducationPKBean implements Serializable {

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
    protected EmployeeInfoBean id;
	
	@JsonProperty("education-type")
    @Column(name = "EDUCATION_TYPE")
    protected String educationType;

    public EmployeeInfoBean getId() {
        return id;
    }

    public void setId(EmployeeInfoBean value) {
        this.id = value;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String value) {
        this.educationType = value;
    }

}
