package com.testyantra.empspringmvc.jaxb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "TRAINING_INFO")
public class TrainingInfoBean implements Serializable {

	@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_TRAININGINFO",
			joinColumns = { @JoinColumn(name = "COURSE_ID") }, 
			inverseJoinColumns = {@JoinColumn(name = "ID") })
    protected List<EmployeeInfoBean> infoBeans;
    
	@JsonProperty("course-id")
    @Id
	@Column(name = "COURSE_ID")
    protected int courseId;
    
	@JsonProperty("course-name")
    @Column(name = "COURSE_NAME")
    protected String courseName;
    
    @Column(name = "DURATION")
    protected int duration;
    
    @JsonProperty("course-type")
    @Column(name = "COURSE_TYPE")
    protected String courseType;

    public List<EmployeeInfoBean> getInfoBeans() {
        if (infoBeans == null) {
            infoBeans = new ArrayList<EmployeeInfoBean>();
        }
        return this.infoBeans;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int value) {
        this.courseId = value;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String value) {
        this.courseName = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String value) {
        this.courseType = value;
    }

}
