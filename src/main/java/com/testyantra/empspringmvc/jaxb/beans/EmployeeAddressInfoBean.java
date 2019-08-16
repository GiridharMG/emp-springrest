package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE_ADDRESSINFO")
public class EmployeeAddressInfoBean implements Serializable {

	@EmbeddedId
    protected EmployeeAddressPKBean addressPKBean;
    
    @Column(name = "ADDRESS1")
    protected String address1;
    
    @Column(name = "ADDRESS2")
    protected String address2;
    
    @Column(name = "LANDMARK")
    protected String landmark;
    
    @Column(name = "CITY")
    protected String city;
    
    @Column(name = "STATE")
    protected String state;
    
    @Column(name = "COUNTRY")
    protected String country;
    
    @Column(name = "PINCODE")
    protected int pincode;

    public EmployeeAddressPKBean getAddressPKBean() {
        return addressPKBean;
    }

    public void setAddressPKBean(EmployeeAddressPKBean value) {
        this.addressPKBean = value;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String value) {
        this.address1 = value;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String value) {
        this.address2 = value;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String value) {
        this.landmark = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int value) {
        this.pincode = value;
    }

}
