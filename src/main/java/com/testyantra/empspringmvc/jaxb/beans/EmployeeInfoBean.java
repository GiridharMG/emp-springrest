package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@SuppressWarnings("serial")
@JsonIdentityInfo(generator = 
	ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonRootName(value = "employee-info")
@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfoBean implements Serializable {

	@JsonProperty(value = "other-info")
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
	protected EmployeeOtherInfoBean otherInfo;

	@JsonProperty(value = "address-info")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPKBean.id")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeAddressInfoBean> addressInfo;

	@JsonProperty(value = "education-info")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPKBean.id")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeEducationInfoBean> educationInfo;

	@JsonProperty(value = "experince-info")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "experincePKBean.id")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeExperinceInfoBean> experinceInfo;

	@JsonProperty(value = "training-info")
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infoBeans")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<TrainingInfoBean> trainingInfo;

	@JsonProperty(value = "department-info")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPT_ID")
	protected DepartmentInfoBean departmentInfo;

	@JsonProperty(value = "manager-id")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MNG_ID", referencedColumnName = "ID")
	protected EmployeeInfoBean managerId;

	//@JsonProperty("emp-id")
	@Id
	@Column(name = "ID")
	protected int id;

	@Column(name = "NAME")
	protected String name;

	@XmlElement(name = "age")
	protected int age;

	@Column(name = "GENDER")
	protected String gender;

	@Column(name = "SALARY")
	protected double salary;

	@JsonProperty("phone-num")
	@Column(name = "PHONE")
	protected long phoneNum;

	@JsonProperty("email-id")
	@Column(name = "EMAIL")
	protected String emailId;

	@Column(name = "DESIGNATION")
	protected String designation;

	@JsonProperty("dob")
	@Column(name = "DOB")
	protected Date dob;

	@JsonProperty("account-number")
	@Column(name = "ACCOUNT_NUMBER")
	protected long accountNumber;

	@JsonProperty("joining-date")
	@Column(name = "JOINING_DATE")
	protected Date joiningDate;

	@Column(name = "PASSWORD")
	protected String password;

	public EmployeeOtherInfoBean getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(EmployeeOtherInfoBean value) {
		this.otherInfo = value;
	}

	public List<EmployeeAddressInfoBean> getAddressInfo() {
		if (addressInfo == null) {
			addressInfo = new ArrayList<EmployeeAddressInfoBean>();
		}
		return this.addressInfo;
	}

	public void setAddessInfo(List<EmployeeAddressInfoBean> addressInfo) {
		this.addressInfo = addressInfo;
	}

	public List<EmployeeEducationInfoBean> getEducationInfo() {
		if (educationInfo == null) {
			educationInfo = new ArrayList<EmployeeEducationInfoBean>();
		}
		return this.educationInfo;
	}

	public List<EmployeeExperinceInfoBean> getExperinceInfo() {
		if (experinceInfo == null) {
			experinceInfo = new ArrayList<EmployeeExperinceInfoBean>();
		}
		return this.experinceInfo;
	}

	public List<TrainingInfoBean> getTrainingInfo() {
		if (trainingInfo == null) {
			trainingInfo = new ArrayList<TrainingInfoBean>();
		}
		return this.trainingInfo;
	}

	public DepartmentInfoBean getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfoBean value) {
		this.departmentInfo = value;
	}

	public EmployeeInfoBean getManagerId() {
		return managerId;
	}

	public void setManagerId(EmployeeInfoBean value) {
		this.managerId = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int value) {
		this.id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int value) {
		this.age = value;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String value) {
		this.gender = value;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double value) {
		this.salary = value;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long value) {
		this.phoneNum = value;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String value) {
		this.emailId = value;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String value) {
		this.designation = value;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long value) {
		this.accountNumber = value;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date value) {
		this.joiningDate = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setAddressInfo(List<EmployeeAddressInfoBean> addressInfo) {
		this.addressInfo = addressInfo;
	}

	public void setEducationInfo(List<EmployeeEducationInfoBean> educationInfo) {
		this.educationInfo = educationInfo;
	}

	public void setExperinceInfo(List<EmployeeExperinceInfoBean> experinceInfo) {
		this.experinceInfo = experinceInfo;
	}

	public void setTrainingInfo(List<TrainingInfoBean> trainingInfo) {
		this.trainingInfo = trainingInfo;
	}

}
