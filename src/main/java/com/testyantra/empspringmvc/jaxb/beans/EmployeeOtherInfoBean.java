package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE_OTHERINFO")
public class EmployeeOtherInfoBean implements Serializable {

	@JsonIgnore
	@Id
	@OneToOne
	@JoinColumn(name = "ID")
    protected EmployeeInfoBean id;
	
	@Column(name = "PAN")
    protected String pan;
	
    @XmlElement(name = "is-married")
    @Column(name = "ISMARRIED")
    protected boolean isMarried;
    
    @Column(name = "AADHAR")
    protected long aadhar;
    
    @JsonProperty(value = "blood-group")
    @Column(name = "BLD_GRP")
    protected String bloodGroup;
    
    @JsonProperty(value = "is-chalenged")
    @Column(name = "ISCHALENGED")
    protected boolean isChalenged;
    
    @JsonProperty(value = "emergency-number")
    @Column(name = "EMG_NUM")
    protected long emergencyNumber;
    
    @JsonProperty(value = "emergency-contact-name")
    @Column(name = "EMG_CONTACT_NAME")
    protected String emergencyContactName;
    
    @Column(name = "NATIONALITY")
    protected String nationality;
    
    @Column(name = "RELIGION")
    protected String religion;
    
    @JsonProperty(value = "father-name")
    @Column(name = "F_NAME")
    protected String fatherName;
    
    @JsonProperty(value = "mother-name")
    @Column(name = "M_NAME")
    protected String motherName;
    
    @JsonProperty(value = "spouse-name")
    @Column(name = "S_NAME")
    protected String spouseName;

    public EmployeeInfoBean getId() {
        return id;
    }

    public void setId(EmployeeInfoBean value) {
        this.id = value;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String value) {
        this.pan = value;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long value) {
        this.aadhar = value;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String value) {
        this.bloodGroup = value;
    }

    public long getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(long value) {
        this.emergencyNumber = value;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String value) {
        this.emergencyContactName = value;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String value) {
        this.nationality = value;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String value) {
        this.religion = value;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String value) {
        this.fatherName = value;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String value) {
        this.motherName = value;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String value) {
        this.spouseName = value;
    }

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public boolean isChalenged() {
		return isChalenged;
	}

	public void setChalenged(boolean isChalenged) {
		this.isChalenged = isChalenged;
	}

}
