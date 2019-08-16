package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Embeddable
public class EmployeeAddressPKBean implements Serializable {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID")
    protected EmployeeInfoBean id;
	
	@JsonProperty("address-type")
    @Column(name = "ADDRESS_TYPE")
    protected String addressType;

    public EmployeeInfoBean getId() {
        return id;
    }

    public void setId(EmployeeInfoBean value) {
        this.id = value;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String value) {
        this.addressType = value;
    }

}
