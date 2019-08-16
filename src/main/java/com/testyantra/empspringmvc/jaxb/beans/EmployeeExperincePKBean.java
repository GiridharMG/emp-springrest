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
public class EmployeeExperincePKBean implements Serializable {

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
    protected EmployeeInfoBean id;
	
    @JsonProperty("company-name")
    @Column(name = "COMPANY_NAME")
    protected String companyName;

    public EmployeeInfoBean getId() {
        return id;
    }

    public void setId(EmployeeInfoBean value) {
        this.id = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
    }

}
